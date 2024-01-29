import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int length = s.length();
        boolean[] checked = new boolean[length];

        rec(checked, s, 0, length - 1);
        System.out.println(sb.toString());
    }

    private static void rec(boolean[] checked, String s, int left, int right) {
        if (left > right) {
            return;
        }

        int idx = left;
        for (int i = left; i <= right; i++) {
            if (s.charAt(i) < s.charAt(idx)) {
                idx = i;
            }
        }

        checked[idx] = true;
        for (int i = 0; i < checked.length; i++) {
            if (checked[i]) {
                sb.append(s.charAt(i));
            }
        }
        sb.append("\n");

        rec(checked, s, idx + 1, right);
        rec(checked, s, left, idx - 1);
    }
}
