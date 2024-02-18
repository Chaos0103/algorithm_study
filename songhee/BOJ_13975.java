import java.io.*;
import java.util.*;
class Solution5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(n-->0) {
            int testNum = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>((o1, o2)-> (int)(o1-o2));
            while(testNum-->0) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            long accumulated = 0L;
            while(pq.size() != 1) {
                long num1 = pq.poll();
                long num2 = pq.poll();
                accumulated += num1+num2;
                pq.add(num1+num2);
            }
            sb.append(accumulated+"\n");
        }
        System.out.println(sb);
    }
}