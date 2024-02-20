import java.io.*;
import java.util.*;
class Solution5 {
    static class IceCream{
        int amount;
        int num;
        IceCream(int amount, int num){
            this.amount = amount;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<IceCream> d = new LinkedList<>();
        PriorityQueue<IceCream> pq = new PriorityQueue<>((o1, o2)-> {
            if(o1.amount == o2.amount) {
                return o1.num - o2.num;
            }
            else {
                return o2.amount-o1.amount;
            }
        });

        st = new StringTokenizer(br.readLine());
        int maxNum = 0;
        for(int i=1;i<=N;i++) {
            int n = Integer.parseInt(st.nextToken());

            pq.add(new IceCream(n, i));
            maxNum = Math.max(maxNum, n);
        }

        while(!pq.isEmpty()) {
            IceCream now = pq.poll();
            if(d.size() < M ) {
                d.addLast(now);
            }else {
                if(now.amount == maxNum) {
                    d.addLast(now);
                }else {
                    break;
                }
            }
        }
        boolean flag = true;
        for(int i=1;i<=M;i++) {
            IceCream now;
            if(flag) {
                now = d.pollFirst();
            }else {
                now = d.pollLast();
            }
            sb.append(now.num+"\n");

            if(now.amount %7 == 0) {
                if(flag) flag = false;
                else flag = true;
            }

        }
        System.out.println(sb);

    }
}