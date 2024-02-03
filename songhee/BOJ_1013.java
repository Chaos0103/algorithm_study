import java.io.*;
import java.util.*;
import java.util.regex.*;
public class BOJ_1013 {
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
        int idx = 0;
        while(idx < pa.length()) {
            if(pa.charAt(idx) == '1') {
                int zCnt = 0;
                idx++;
                while(idx<pa.length()) {
                    if(pa.charAt(idx) == '0') {
                        zCnt++;
                        idx++;
                    }else break;
                }
                if(zCnt < 2) return false;

                int oCnt = 0;
                while(idx<pa.length()) {
                    if(pa.charAt(idx) == '1') {
                        if(isRepeat(idx, pa)) {
                            break;
                        }
                        oCnt++;
                        idx++;
                    }else break;
                }
                if(oCnt < 1) return false;

            }else if(pa.charAt(idx) == '0') {
                int oCnt = 0;
                idx++;
                while(idx<pa.length()) {
                    if(pa.charAt(idx) == '1') {
                        oCnt++;
                        idx++;
                        break;
                    }else break;
                }
                if(oCnt != 1) return false;
            }
        }
        return true;
    }

    private static boolean isRepeat(int idx, String pa) {
        if(idx < pa.length() && idx+1 < pa.length() && idx+2<pa.length()) {
            if(pa.substring(idx, idx+3).equals("100")) {
                return true;
            }
        }
        return false;
    }
}
