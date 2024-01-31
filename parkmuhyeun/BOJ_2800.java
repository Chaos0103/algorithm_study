import java.io.*;
import java.util.*;

public class Main {

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] arr = s.toCharArray();

        final int length = arr.length;
        int[] pair = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (arr[i] == '(') {
                stack.push(i);
            } else if (arr[i] == ')') {
                pair[i] = stack.peek();
                pair[stack.peek()] = i;
                stack.pop();
            }
        }

        boolean[] visit = new boolean[length];
        dfs(0, visit, pair, arr);
        set.remove(s);

        set.stream().sorted().forEach(System.out::println);
    }

    private static void dfs(int idx, boolean[] visit, int[] pair, char[] arr) {
        if (idx == arr.length) {
            print(arr, visit);
            return;
        }

        if (arr[idx] == '(') {
            visit[idx] = true;
            visit[pair[idx]] = true;
            dfs(idx + 1, visit, pair, arr);

            visit[idx] = false;
            visit[pair[idx]] = false;
        }

        dfs(idx + 1, visit, pair, arr);
    }

    private static void print(char[] arr, boolean[] visit) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (!visit[i]) {
                sb.append(arr[i]);
            }
        }
        set.add(sb.toString());
    }
}
