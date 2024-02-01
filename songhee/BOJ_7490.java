import java.io.BufferedReader;
import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ_7490 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while(n-->0) {
            int num = Integer.parseInt(br.readLine());
            find(num, 1, "1");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void find(int num, int i, String string) {
        if(num == i) {
            calculate(string);
            return;
        }
        find(num, i+1, string+' '+(i+1));
        find(num, i+1, string+'+'+(i+1));
        find(num, i+1, string+'-'+(i+1));

    }

    private static void calculate(String string) {
        String original = string;
        string = string.replaceAll(" ", "");
        String[] arr = string.split("[+,-]");
        Iterator<Integer> it = Arrays.stream(arr)
            .map(Integer::parseInt).collect(toList()).iterator();

        int sum = it.next();
        for(int i=0;i<string.length();i++) {
            if(string.charAt(i) == '+') {
                sum += it.next();
            }else if(string.charAt(i) == '-') {
                sum -= it.next();
            }
        }
        if(sum == 0) {
            sb.append(original+"\n");
        }
    }

}
