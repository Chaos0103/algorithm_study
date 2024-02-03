import java.io.*;
import java.util.*;
import java.util.regex.*;
public class BOJ_1013_regex {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while(n-- >0) {
            String pa = br.readLine();
            if(check(pa)) {
                sb.append("YES"+"\n");
            }else {
                sb.append("NO"+"\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean check(String pa) {
        //return Pattern.matches("(100+1+|01)+", pa);
        //return pa.matches("(100+1+|01)+");
        Pattern pattern = Pattern.compile("(100+1+|01)+");
        Matcher matcher = pattern.matcher(pa);
        return matcher.matches();
    }
}
