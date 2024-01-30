import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String target;
    static int targetLength;
    static boolean res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = br.readLine();
        targetLength = target.length();

        firstPattern("", 0);
        secondPattern("", 0);

        if (res) {
            System.out.println("SUBMARINE");
        } else {
            System.out.println("NOISE");
        }
    }

    private static void firstPattern(String now, int length) {
        if (length >= targetLength) {
            if (target.equals(now)) {
                res = true;
            }
            return;
        }

        ten(now, length);
        zeroOne(now, length);
    }

    private static void ten(String now, int length) {
        if (!target.startsWith("10", length)) {
            return;
        }

        zero(now + "10", length + 2);
    }

    private static void zero(String now, int length) {
        if (!target.startsWith("0", length)) {
            return;
        }

        zero(now + "0", length + 1);
        one(now + "0", length + 1);
    }

    private static void one(String now, int length) {
        if (!target.startsWith("1", length)) {
            return;
        }
        one(now + "1", length + 1);
        firstPattern(now + "1", length + 1);
    }

    private static void secondPattern(String now, int length) {
        if (length >= targetLength) {
            if (target.equals(now)) {
                res = true;
            }
            return;
        }

        zeroOne(now, length);
        ten(now, length);
    }

    private static void zeroOne(String now, int length) {
        if (!target.startsWith("01", length)) {
            return;
        }
        secondPattern(now + "01", length + 2);
    }
}
