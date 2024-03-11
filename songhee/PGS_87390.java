import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[][] arr = new int[n+1][n+1];
        int[] answer = new int[(int)(right-left)+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                arr[i][j] = Math.max(i, j);
            }
        }

        int idx = 0;
        long num = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(num>= left && num <= right){
                    answer[idx++] = arr[i][j];

                }else if(num>right){
                    return answer;
                }
                num++;
            }
        }


        return answer;
    }
}