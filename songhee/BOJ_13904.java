import java.io.*;
import java.util.*;
public class Solution4 {
    static class ToDo{
        int days;
        int score;
        ToDo(int days, int score){
            this.days = days;
            this.score = score;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<ToDo> pq = new PriorityQueue<>((o1, o2)->{
            if(o1.days == o2.days) {
                return o2.score-o1.score;
            }else {
                return o2.days-o1.days;
            }
        });
        int maxDay = 0;
        while(n-->0) {
            st = new StringTokenizer(br.readLine());
            int days = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            maxDay = Math.max(maxDay, days);

            pq.add(new ToDo(days, score));
        }

        int sum = 0;
        PriorityQueue<ToDo> spq = new PriorityQueue<>((o1, o2)-> o2.score- o1.score);

        for(int i=maxDay;i>0;i--) {
            while(!pq.isEmpty()) {
                if(pq.peek().days == i) {
                    spq.add(pq.poll());
                }else {
                    break;
                }
            }
            if(!spq.isEmpty()) {
                sum += spq.poll().score;
            }
        }

        System.out.println(sum);
    }

}
