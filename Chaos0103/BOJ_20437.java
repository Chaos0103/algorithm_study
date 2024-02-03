import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if (k == 1) {
                System.out.println("1 1");
                continue;
            }

            int[] counts = new int[26];
            for (char c : str.toCharArray()) {
                counts[c - 'a']++;
            }

            int max = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < str.length(); i++) {
                if (counts[str.charAt(i) - 'a'] < k) {
                    continue;
                }

                int count = 1;
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(i) == str.charAt(j)) {
                        count++;
                    }

                    if (count == k) {
                        max = Math.max(max, j - i + 1);
                        min = Math.min(min, j - i + 1);
                        break;
                    }
                }
            }

            if (min == Integer.MAX_VALUE || max == -1) {
                System.out.println("-1");
            } else {
                System.out.println(min + " " + max);
            }
        }
    }
}
