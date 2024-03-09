import java.util.*;
import java.io.*;
class Solution {
    static int num, minNum;
    static boolean v[];
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        v = new boolean[100000001];

        int minA = 100000000;
        for(int i=0;i<arrayA.length;i++){
            minA = Math.min(minA, arrayA[i]);
            v[arrayA[i]] = true;
        }

        int minB = 100000000;
        for(int i=0;i<arrayB.length;i++){
            minB = Math.min(minB, arrayB[i]);
            v[arrayB[i]] = true;
        }

        minNum = Math.max(minA, minB);
        System.out.println(minNum);

        for(int i=1;i<=minNum && v[i] ;i++){

            boolean arrayACheck = true;
            boolean check1 = true;
            if(arrayA[0] %i != 0){
                check1 = false;
            }
            for(int j=0;j<arrayA.length;j++){
                if(check1 == true && (arrayA[j] < i || arrayA[j]%i != 0)){
                    arrayACheck = false;
                    break;
                }else if(check1 == false && (arrayA[j] >= i && arrayA[j] == 0)){
                    arrayACheck = false;
                    break;
                }
            }

            boolean arrayBCheck = true;
            boolean check2 = true;

            if(arrayB[0] %i != 0){
                check2 = false;
            }
            for(int j=0;j<arrayB.length;j++){
                if(check2 == true && (arrayB[j] < i || arrayB[j]%i != 0)){
                    arrayBCheck = false;
                    break;
                }else if(check2 == false && (arrayB[j] >= i && arrayB[j] == 0)){
                    arrayBCheck = false;
                    break;
                }
            }


            num = Math.max(num, i);
            allCheck(i);
        }


        return num;
    }
    static void allCheck(int n){
        for(int i=n;i<=100000000;i+=n){
            if(v[i]){
                v[i] = false;
            }
        }
    }
}