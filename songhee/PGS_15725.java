import java.util.*;
class PGS_15725 {
    public int solution(int[] bid, int[] ask, int n) {
        PriorityQueue<Integer> arrAsk = new PriorityQueue<>((o1, o2)->o1-o2);
        PriorityQueue<Integer> arrBid = new PriorityQueue<>((o1, o2)->o2-o1);

        int minAsk = 100000;
        int maxBid = 0;
        for(int i=0;i<ask.length;i++){
            arrAsk.add(ask[i]);
            minAsk = Math.min(minAsk, ask[i]);
        }

        for(int i=0;i<bid.length;i++){
            arrBid.add(bid[i]);
            maxBid = Math.max(maxBid, ask[i]);
        }

        if(minAsk > maxBid) return 0;

        int sum = 0;
        int num = n/2;
        int maxSum = 0;

        for(int i=0;i<num;i++){
            int b = arrBid.poll();
            int a = arrAsk.poll();
            maxSum = Math.max(maxSum, sum + b - a);
            sum += b-a;
        }

        return maxSum;
    }
}