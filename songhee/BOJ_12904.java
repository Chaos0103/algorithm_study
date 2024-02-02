import java.io.*;
import java.util.*;
public class BOJ_12904 {
    static String S, T;
    static boolean isPossible = false;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        find(T);
        if(isPossible) System.out.println(1);
        else System.out.println(0);
    }
    private static void find(String transform) {
        if(transform.length() == S.length()) {
            if(transform.equals(S)) {
                isPossible = true;
            }
            return;
        }

        char last = transform.charAt(transform.length()-1);
        if(last == 'A') {
            find(transform.substring(0, transform.length()-1));
        }else {
            StringBuilder sb = new StringBuilder(transform);
            sb.delete(transform.length()-1, transform.length());
            find(sb.reverse().toString());
        }
    }
}
