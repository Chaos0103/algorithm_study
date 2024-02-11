import java.io.*;
import java.util.*;

public class BOJ_23284 {

    static Stack<Integer> st = new Stack<>();
    static int n;
    static int num[11];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        find(0, 0);

        System.out.println(sb);

    }
    private static void find(int cnt, int next){
        if(cnt == n){
            for(int i=0;i<n;i++){
                sb.append(num[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=n;i++){
            boolean flag = true;

            num[cnt] = i;
            for(int j=0;j<cnt;j++){
                if(num[j] == num[cnt]){
                    flag = false;
                }
            }

            if(flag){
                if(num[cnt-1] < num[cnt] && num[cnt] < next){
                    break;
                }
                if(num[cnt] >= next){
                    find(cnt+1, num[cnt]+1);
                }else{
                    find(cnt+1, next);
                }
            }
        }
    }
}