import java.io.*;
import java.util.*;
public class BOJ_6198 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        long answer = 0;
        for(int i=0;i<n;i++) {
            long sum = 0;
            for(int j=i+1;j<n;j++) {
                if(arr[i]<=arr[j]) {
                    answer += sum;
                    break;
                }else {
                    sum++;

                    if(j == n-1) {
                        answer += sum;
                    }
                }
            }

        }

        System.out.println(answer);
    }
}
