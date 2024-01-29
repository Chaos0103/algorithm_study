import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            stack.push(ch);

            if (stack.size() >= bomb.length()) {
                boolean flag = true;
                for (int i = 0; i < bomb.length(); i++) {
                    if (stack.get(stack.size() - bomb.length() + i) != bomb.charAt(i)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int i = 0; i < bomb.length(); i++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (Character ch : stack) {
            builder.append(ch);
        }
        System.out.println(builder.length() == 0 ? "FRULA" : builder);
    }
}
