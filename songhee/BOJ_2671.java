import java.util.*;
import java.io.*;
class BOJ_2671{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String s = br.readLine();
        boolean flag = true;
        String copy = "";
        for(int i=0;i<s.length();) {
            char nextChar = s.charAt(i);

            if(nextChar == '1') {
                int zeroCnt = 0; int idx = i+1;
                if(idx >= s.length()) {
                    flag = false; break;
                }
                while(s.charAt(idx) == '0') {
                    zeroCnt++;
                    idx++;
                    if(idx >= s.length()) break;
                }

                if(zeroCnt < 2) {
                    flag = false; break;
                }

                int oneCnt = 0;
                if(idx >= s.length()) {
                    flag = false; break;
                }
                while(s.charAt(idx) == '1') {
                    if(oneCnt >=1) {
                        if(idx+2 < s.length()) {
                            if(s.substring(idx+1, idx+3).equals("00")) break;
                        }
                    }
                    oneCnt++;
                    idx++;
                    if(idx >= s.length()) break;
                }

                if(oneCnt <1) {
                    flag = false; break;
                }

                i = idx;


            }else if(nextChar == '0') {
                if(i+1 >= s.length()) {
                    flag = false;
                    break;
                }
                if(s.charAt(i+1)!= '1') {
                    flag = false;
                    break;
                }else if(s.charAt(i+1) == '1') i+=2;
            }
        }

        if(flag) System.out.println("SUBMARINE");
        else System.out.println("NOISE");

    }

}