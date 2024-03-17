import java.util.*;
import java.io.*;
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (e1,e2)->{
            if(e1[1]==e2[1]){
                return e1[0]-e2[0];
            }
            return e1[1]-e2[1];
        });
        
        int count = 1;
        int end = targets[0][1];
        
        for(int []target: targets){
            if(end <= target[0]){
                count++;
                end = target[1];
            }
        }
        
        return count;
    }
}
