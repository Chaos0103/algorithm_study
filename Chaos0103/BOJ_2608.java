import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<Character, Integer> map = new HashMap<>();

    private static void init() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    private static int strToInt(String str) {
        int result = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            int current = map.get(str.charAt(i));
            int next = map.get(str.charAt(i + 1));
            if (current < next) {
                result -= current;
            } else {
                result += current;
            }
        }
        return result + map.get(str.charAt(str.length() - 1));
    }

    private static String intToStr(int num) {
        StringBuilder builder = new StringBuilder();
        String[] keys = "IVXLCDM".split("");

        int index = 1;
        while (num > 0) {
            int n = num % 10;
            if (n <= 3) {
                builder.append(keys[index - 1].repeat(n));
            } else if (n == 4) {
                builder.append(keys[index]).append(keys[index - 1]);
            } else if (n == 5) {
                builder.append(keys[index]);
            } else if (n <= 8) {
                builder.append(keys[index - 1].repeat(n - 5)).append(keys[index]);
            } else {
                builder.append(keys[index + 1]).append(keys[index - 1]);
            }
            num /= 10;
            index += 2;
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        init();

        int num1 = strToInt(str1);
        int num2 = strToInt(str2);
        int sum = num1 + num2;
        String str = intToStr(sum);
        System.out.println(sum);
        System.out.println(str);
    }
}
