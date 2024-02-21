import java.util.Stack;

class Solution {
    private boolean isValid(char[] arr, int startIndex) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[(startIndex + i) % arr.length];

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            if (c == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }

            if (c == ']' && stack.peek() == '[') {
                stack.pop();
                continue;
            }

            if (c == '}' && stack.peek() == '{') {
                stack.pop();
                continue;
            }

            return false;
        }

        return stack.isEmpty();
    }

    public int solution(String s) {
        char[] arr = s.toCharArray();

        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            answer = isValid(arr, i) ? (answer + 1) : answer;
        }

        return answer;
    }
}
