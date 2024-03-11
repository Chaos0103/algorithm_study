import java.io.*;
import java.util.*;
class Solution
{
    static boolean av[], bv[];
    static int minNum = 1000000000;
    static int arrA[], arrB[];
    public int solution(int []A, int []B)
    {
        int answer = 0;

        av = new boolean[A.length];
        bv = new boolean[B.length];

        arrA = A.clone();
        arrB = B.clone();

        allFind(0, 0);

        return minNum;
    }
    static void allFind(int total, int num){
        if(total > minNum) return;
        if(num == arrA.length){
            minNum = Math.min(minNum, total);
            return;
        }

        for(int i=0;i<arrA.length;i++){
            for(int j=0;j<arrB.length;j++){
                if(!av[i] && !bv[j]){
                    av[i] = true;
                    bv[j] = true;
                    allFind(total + arrA[i]*arrB[j], num+1);
                    av[i] = false;
                    bv[j] = false;
                }
            }
        }

    }
}