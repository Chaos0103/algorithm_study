import java.util.*;
import java.io.*;
class PGS_42584 {
    static class Position{
        int n;
        int idx;
        Position(int n, int idx){
            this.n = n;
            this.idx = idx;
        }
    }
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Position minNum = null; Position maxNum = null;
        for(int i=prices.length-1;i>=0;i--){
            if(minNum == null && maxNum == null){
                minNum = new Position(prices[i], i);
                answer[i] = 0;
            }else{
                if(maxNum == null && minNum.n < prices[i]){
                    maxNum = new Position(prices[i], i);
                    answer[i] = 1;
                }else if(maxNum == null && minNum.n >= prices[i]){
                    maxNum = minNum;
                    minNum = new Position(prices[i], i);
                    answer[i] = maxNum.idx-minNum.idx;
                }
                else if(maxNum.n>prices[i]){
                    minNum = new Position(prices[i], i);
                    answer[i] = maxNum.idx-minNum.idx;
                }else if(maxNum.n == prices[i]){
                    if(minNum.idx-i < maxNum.idx-i){
                        answer[i] = minNum.idx-i;
                    }else{
                        answer[i] = maxNum.idx-i;
                    }
                }else{
                    maxNum = new Position(prices[i], i);
                    answer[i] = 1;
                }
            }

        }




        return answer;
    }
}