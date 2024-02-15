import java.io.*;
import java.util.*;
class BOJ_1374 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2)->{
            if(o1[0] == o2[0]) {
                return (int)(o1[1] - o2[1]);
            }else {
                return (int)(o1[0]-o2[0]);
            }
        });

        while(n-->0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            long start = Integer.parseInt(st.nextToken());
            long end = Integer.parseInt(st.nextToken());

            long arr[] = new long[] {start, end};
            pq.add(arr);
        }
        int size = pq.size();
        int answer = 0;
        PriorityQueue<Long> endQ = new PriorityQueue<>();
        while(size -- >0) {
            long arr[] = pq.poll();
            if(!endQ.isEmpty() && endQ.peek() <= arr[0]) {
                endQ.poll();
            }
            endQ.add(arr[1]);
        }
        System.out.println(endQ.size());
    }
}