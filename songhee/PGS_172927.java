import java.util.*;
class PGS_172927 {
    static int num, minSum = Integer.MAX_VALUE;
    static int arr[][];
    static String mineralsArr[];
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        arr = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                arr[i][j] = 1;
            }
        }
        arr[1][0] = 5;
        arr[2][0] = 25; arr[2][1] = 5;

        mineralsArr = minerals;

        int mineralsCnt = minerals.length;
        num = mineralsCnt/5;
        if(mineralsCnt%5 != 0) num++;

        find(0, 0, 0, picks);

        return minSum;
    }
    public static void find(int count, int sum, int startIdx, int []picks){
        int picksCnt = 0;
        for(int i=0;i<picks.length;i++){
            if(picks[i] != 0) picksCnt++;
        }
        if(picksCnt == 0) {
            minSum = Math.min(sum, minSum);
            return;
        }


        if(count == num){
            minSum = Math.min(sum, minSum);
            return;
        }

        for(int i=0;i<picks.length;i++){
            if(picks[i] == 0) continue;

            int diaCnt = 0;
            int ironCnt = 0;
            int stoneCnt = 0;
            for(int j=startIdx;j<startIdx+5 && j<mineralsArr.length; j++){
                if(mineralsArr[j].equals("diamond")){
                    diaCnt++;
                }else if(mineralsArr[j].equals("stone")){
                    stoneCnt++;
                }else{
                    ironCnt++;
                }
            }

            int single = diaCnt*arr[i][0] + ironCnt*arr[i][1] + stoneCnt*arr[i][2];
            picks[i]--;

            find(count+1, sum+single, startIdx+5, picks);

            picks[i]++;
        }
    }
}