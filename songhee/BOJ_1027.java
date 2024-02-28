import java.io.*;
import java.util.*;
class BOJ_1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int maxSum = 0;
        for(int i=0;i<n;i++) {
            int sum = 0;
            double left = 0;
            for(int j=i-1;j>=0;j--) {
                double a = (double)(arr[i]-arr[j])/(i-j);
                if(j == i-1) {
                    left = a;
                    sum++;
                }else if(left>a) {
                    left = a;
                    sum++;
                }
            }

            double right = 0;
            for(int j=i+1;j<n;j++) {
                double a = (double)(arr[j]-arr[i])/(j-i);
                if(j == i+1) {
                    right = a;
                    sum++;
                }else if(right<a){
                    right = a;
                    sum++;
                }
            }
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}