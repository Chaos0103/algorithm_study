import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s.equals("::")) {
            System.out.println("0000:".repeat(7) + "0000");
            return;
        }

        if (!s.startsWith("::") && s.startsWith(":")) {
            s = "0000" + s;
        }
        if (!s.endsWith("::") && s.endsWith(":")) {
            s = s + "0000";
        }

        if (s.contains("::")) {
            String[] split = s.split(":");
            int length = split.length;
            if (s.startsWith("::")) {
                s = s.replace("::", "0000:".repeat(8 - (length - 2)));
            } else if (s.endsWith("::")) {
                s = s.replace("::", ":0000".repeat(8 - (length)));
            } else {
                s = s.replace("::", ":" + "0000:".repeat(8 - (length - 1)));
            }
        }

        StringBuilder sb = new StringBuilder();
        String[] split = s.split(":");
        int length = split.length;;
        for (int i = 0; i < length; i++) {
            String splitS = split[i];
            sb.append("0".repeat(4 - splitS.length())).append(splitS);
            if (i != length - 1) {
                sb.append(":");
            }
        }
        System.out.println(sb);
    }
}