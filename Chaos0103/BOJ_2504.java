import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> s = new Stack<>();
        int result = 0;
        int value = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                s.push(c);
                value *= 2;
            } else if (c == '[') {
                s.push(c);
                value *= 3;
            } else if (c == ')') {
                if (s.isEmpty() || s.peek() != '(') {
                    result = 0;
                    break;
                } else if (str.charAt(i - 1) == '(') {
                    result += value;
                }
                value /= 2;
                s.pop();
            } else if (c == ']') {
                if (s.isEmpty() || s.peek() != '[') {
                    result = 0;
                    break;
                } else if (str.charAt(i - 1) == '[') {
                    result += value;
                }
                value /= 3;
                s.pop();
            }
        }

        if (!s.isEmpty()) {
            result = 0;
        }

        System.out.println(result);
    }
}
