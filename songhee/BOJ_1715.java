import java.io.*;
import java.util.*;
public class BOJ_1715 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)-> o1-o2);
        while(n-->0) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        //10+20 = 30
        // 30+40 = 70
        int total = 0;
        while(!pq.isEmpty()) {
            if(pq.size() == 1) {
                System.out.println(total);
                return;
            }else {
                int a = pq.poll();
                int b = pq.poll();
                total += a+b;
                pq.add(a+b);
            }
        }
    }
}
