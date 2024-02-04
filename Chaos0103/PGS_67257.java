import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

    private static final String[][] OPERATIONS = {
        "+-*".split(""),
        "+*-".split(""),
        "-*+".split(""),
        "-+*".split(""),
        "*-+".split(""),
        "*+-".split("")
    };

    private long calculate(List<String> tokens, int index) {
        String[] operations = OPERATIONS[index];
        for (String operation : operations) {
            for (int i = 0; i < tokens.size(); i++) {
                String token = tokens.get(i);
                if (token.equals(operation)) {
                    long left = Long.parseLong(tokens.get(i - 1));
                    long right = Long.parseLong(tokens.get(i + 1));
                    long result = 0;
                    switch (operation) {
                        case "+":
                            result = left + right;
                            break;
                        case "-":
                            result = left - right;
                            break;
                        case "*":
                            result = left * right;
                            break;
                    }
                    tokens.remove(i + 1);
                    tokens.remove(i);
                    tokens.remove(i - 1);

                    tokens.add(i - 1, Long.toString(result));
                    i -= 2;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }

    public long solution(String expression) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer token = new StringTokenizer(expression, "+-*", true);
        while (token.hasMoreTokens()) {
            tokens.add(token.nextToken());
        }

        long answer = 0;
        for (int i = 0; i < 6; i++) {
            long result = calculate(new ArrayList<>(tokens), i);
            answer = Math.max(answer, Math.abs(result));
        }

        return answer;
    }
}
