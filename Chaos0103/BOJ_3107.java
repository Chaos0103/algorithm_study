import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int TOTAL_PARTITION_COUNT = 15;
    private static final String ZERO = "0000";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        String str = br.readLine();
        StringTokenizer token = new StringTokenizer(str, ":", true);

        int count = Math.round((float) (TOTAL_PARTITION_COUNT - token.countTokens()) / 2);

        if (str.startsWith(":")) {
            builder.append(ZERO);
        }

        String prev = "";
        while (token.hasMoreTokens()) {
            String part = token.nextToken();
            if (part.equals(":")) {
                if (prev.equals(":")) {
                    builder.append((ZERO + ":").repeat(count));
                } else {
                    builder.append(part);
                }
                prev = part;
                continue;
            }

            int num = Integer.parseInt(part, 16);
            builder.append(String.format("%04x", num));
            prev = part;
        }

        if (str.endsWith(":")) {
            builder.append(ZERO);
        }

        System.out.println(builder);
    }
}
