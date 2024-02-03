import java.io.*;
import java.util.*;
public class BOJ_20437 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while(n-- >0) {
            String s = br.readLine();
            int k = Integer.parseInt(br.readLine());
            int arr[] = new int[50];
            for(int i=0;i<s.length();i++) {
                arr[s.charAt(i)-'a']++;
            }

            int idx = 0; int maxLen = 0; int minLen = Integer.MAX_VALUE;
            while(idx<s.length()) {
                char ch = s.charAt(idx);
                int originIdx = idx;
                if(arr[ch-'a']>=k) {
                    int sum = 0;
                    while(idx<s.length()) {
                        if(s.charAt(idx) == ch) {
                            sum++;
                        }

                        if(sum == k) break;
                        idx++;
                    }

                    if(sum == k) {
                        maxLen = Math.max(maxLen, idx-originIdx+1);
                        minLen = Math.min(minLen, idx-originIdx+1);
                    }
                }
                idx = originIdx+1;
            }

            if(maxLen == 0 || minLen == Integer.MAX_VALUE) {
                sb.append(-1+"\n");
            }else {
                sb.append(minLen+" "+maxLen+"\n");
            }
        }
        System.out.print(sb);
    }
}
