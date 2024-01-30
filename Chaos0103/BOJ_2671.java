import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String REGEX = "(100+1+|01)+";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        boolean isMatches = str.matches(REGEX);

        System.out.println(isMatches ? "SUBMARINE" : "NOISE");
    }
}
