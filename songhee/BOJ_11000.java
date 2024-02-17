import java.io.*;
import java.util.*;
public class BOJ_11000 {
    static class Study{
        int start;
        int end;
        Study(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Study> pq = new PriorityQueue<>((o1, o2)-> {
            if(o1.start == o2.start) {
                return o1.end-o2.end;
            }else {
                return o1.start - o2.start;
            }
        });
        while(n-->0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.add(new Study(start, end));
        }
        PriorityQueue<Integer> rest = new PriorityQueue<>((o1, o2)-> o1-o2);

        int count = 0;
        while(!pq.isEmpty()) {
            Study now = pq.poll();
            int size = rest.size();
            if(rest.isEmpty() || rest.peek() > now.start) {
                count++;
            }else if(rest.peek() <= now.start) {
                rest.poll();
            }
            rest.add(now.end);
        }
        System.out.println(count);

    }

}
