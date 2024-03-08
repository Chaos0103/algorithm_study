import java.util.*;
import java.io.*;
class Solution {
    static int count, health;
    static int[][] dun;
    static boolean v[];
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        dun = new int[dungeons.length][2];
        for(int i=0;i<dungeons.length;i++){
            dun[i] = dungeons[i].clone();
        }
        health = k;
        v = new boolean[dun.length];
        dfs(0, 0);

        return count;
    }
    static void dfs(int idx, int c){

        count = Math.max(c, count);

        for(int i=0;i<dun.length;i++){
            if(!v[i] && health>=dun[i][0]){
                v[i] = true;
                health -= dun[i][1];
                dfs(idx+1, c+1);
                v[i] = false;
                health += dun[i][1];
            }
        }
    }
}