import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        boolean isReversed = false;
        StringBuilder str = new StringBuilder(T);

        while (str.length() > S.length()) {
            if (isReversed) {
                if (str.substring(0, 1).equals("B")) {
                    isReversed = false;
                }
                str.deleteCharAt(0);
            } else {
                if (str.substring(str.length() - 1).equals("B")) {
                    isReversed = true;
                }
                str.deleteCharAt(str.length() - 1);
            }
        }

        if (isReversed) {
            str.reverse();
        }

        System.out.println(str.toString().equals(S) ? 1 : 0);
    }
}
