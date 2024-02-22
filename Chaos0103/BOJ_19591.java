import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static final Deque<String> token = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        generateToken(str);

        while (token.size() > 5) {
            String left1 = token.pollFirst();
            String leftOperator = token.pollFirst();
            String left2 = token.pollFirst();

            String right1 = token.pollLast();
            String rightOperator = token.pollLast();
            String right2 = token.pollLast();

            if ("*/".contains(leftOperator) && "+-".contains(rightOperator)) {
                String result = calc(left1, left2, leftOperator);
                token.addFirst(result);
                token.addLast(right2);
                token.addLast(rightOperator);
                token.addLast(right1);
            } else if ("+-".contains(leftOperator) && "*/".contains(rightOperator)) {
                String result = calc(right2, right1, rightOperator);
                token.addFirst(left2);
                token.addFirst(leftOperator);
                token.addFirst(left1);
                token.addLast(result);
            } else {
                String leftResult = calc(left1, left2, leftOperator);
                String rightResult = calc(right2, right1, rightOperator);
                if (Long.parseLong(leftResult) >= Long.parseLong(rightResult)) {
                    token.addFirst(leftResult);
                    token.addLast(right2);
                    token.addLast(rightOperator);
                    token.addLast(right1);
                } else {
                    token.addFirst(left2);
                    token.addFirst(leftOperator);
                    token.addFirst(left1);
                    token.addLast(rightResult);
                }
            }
        }

        if (token.size() == 5) {
            String left = token.pollFirst();
            String leftOperator = token.pollFirst();
            String mid = token.pollFirst();
            String rightOperator = token.pollFirst();
            String right = token.pollFirst();

            if ("*/".contains(leftOperator) && "+-".contains(rightOperator)) {
                String result = calc(left, mid, leftOperator);
                token.add(result);
                token.add(rightOperator);
                token.add(right);
            } else if ("+-".contains(leftOperator) && "*/".contains(rightOperator)) {
                String result = calc(mid, right, rightOperator);
                token.add(left);
                token.add(leftOperator);
                token.add(result);
            } else {
                String leftResult = calc(left, mid, leftOperator);
                String rightResult = calc(mid, right, rightOperator);
                if (Long.parseLong(leftResult) >= Long.parseLong(rightResult)) {
                    token.add(leftResult);
                    token.add(rightOperator);
                    token.add(right);
                } else {
                    token.add(left);
                    token.add(leftOperator);
                    token.add(rightResult);
                }
            }
        }

        if (token.size() == 3) {
            String left = token.pollFirst();
            String operator = token.pollFirst();
            String right = token.pollFirst();
            token.add(calc(left, right, operator));
        }

        System.out.println(Long.parseLong(token.poll()));
    }

    private static void generateToken(String str) {
        StringTokenizer st = new StringTokenizer(str, "+-*/", true);
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            token.add(t);
        }

        String s = token.pollFirst();
        if (s.equals("-")) {
            s += token.pollFirst();
        }
        token.addFirst(s);
    }

    private static String calc(String left, String right, String operator) {
        long result = 0;
        long num1 = Long.parseLong(left);
        long num2 = Long.parseLong(right);

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = Math.abs(num1) / Math.abs(num2);
                if (num1 < 0 || num2 < 0) {
                    result *= -1;
                }
                break;
        }

        return Long.toString(result);
    }
}
