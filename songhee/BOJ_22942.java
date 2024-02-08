import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_22942 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[n][2];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            arr[i][0] = x-r;
            arr[i][1] = x+r;
        }

        Arrays.sort(arr, (o1, o2)->{
            if(o1[0] == o2[0]) return o1[1]-o2[1];
            return o1[0]-o2[0];
        });

        int left = arr[0][0];
        int right = arr[0][1];
        boolean isTrue = true;
        for(int i=1;i<n;i++) {
            if(right >= arr[i][0] && right <= arr[i][1]) {
                isTrue = false;
                break;
            }else {
                left = arr[i][0];
                right = arr[i][1];
            }

        }
        if(isTrue) System.out.println("YES");
        else System.out.println("NO");
    }
}
