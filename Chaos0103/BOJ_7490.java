import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private static final String[] OPERATION = {"+", "-", " "};
    private static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = IntStream.range(1, n + 1).toArray();

            set = new HashSet<>();

            dfs(arr, 0, 0, "");
            dfs(arr, 0, 1, "");
            dfs(arr, 0, 2, "");

            set.stream().sorted().forEach(System.out::println);
            System.out.println();
        }
    }

    private static void dfs(int[] arr, int depth, int i, String result) {
        if (depth == arr.length - 1) {
            result += arr[depth];
            StringTokenizer tokenizer = new StringTokenizer(result.replace(" ", ""), "+-", true);
            if (tokenizer.countTokens() == 1) {
                return;
            }

            int sum = Integer.parseInt(tokenizer.nextToken());
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                if (token.equals("+")) {
                    sum += Integer.parseInt(tokenizer.nextToken());
                } else {
                    sum -= Integer.parseInt(tokenizer.nextToken());
                }
            }

            if (sum == 0) {
                set.add(result);
            }

            return;
        }

        dfs(arr, depth + 1, 0, result + arr[depth] + OPERATION[i]);
        dfs(arr, depth + 1, 1, result + arr[depth] + OPERATION[i]);
        dfs(arr, depth + 1, 2, result + arr[depth] + OPERATION[i]);
    }
}
