import java.util.*;
import java.io.*;
public class BOJ_2504 {
    static Stack<Character> stack = new Stack<>();
    static private final char roundOpen = '(';
    static private final char roundClose = ')';
    static private final char sqareOpen = '[';
    static private final char sqareClose = ']';
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        boolean flag = true;
        int answer = 0;
        int cnt = 1;
        for (int i = 0; i < string.length(); i++) {
            char cur = string.charAt(i);
            if (cur == roundOpen) {
                stack.push(cur);
                cnt *= 2;
            } else if (cur == sqareOpen) {
                stack.push(cur);
                cnt *= 3;
            } else {
                if (cur == roundClose) {
                    if (stack.isEmpty() || stack.peek() != roundOpen) {
                        flag = false;
                        break;
                    }
                    if (string.charAt(i - 1) == roundOpen) {
                        answer += cnt;
                    }
                    stack.pop();
                    cnt /= 2;
                } else if (cur == sqareClose) {
                    if (stack.isEmpty() || stack.peek() != sqareOpen) {
                        flag = false;
                        break;
                    }
                    if (string.charAt(i - 1) == sqareOpen) {
                        answer += cnt;
                    }
                    stack.pop();
                    cnt /= 3;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        if (!flag || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}