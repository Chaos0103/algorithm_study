import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int length;
    private static Set<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String str = br.readLine();

            length = str.length();
            result = new HashSet<>();

            char[] arr = str.toCharArray();
            int[] counts = new int[26];
            for (char c : arr) {
                counts[c - 'a']++;
            }

            dfs(counts, "");

            result.stream().sorted()
                .forEach(r -> builder.append(r).append("\n"));
        }

        System.out.println(builder);
    }

    private static void dfs(int[] visited, String s) {
        if (s.length() == length) {
            result.add(s);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (visited[i] > 0) {
                visited[i]--;
                char c = (char) (i + 'a');
                dfs(visited, s + c);
                visited[i]++;
            }
        }
    }
}
