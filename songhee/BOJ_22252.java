import java.io.*;
import java.util.*;
public class BOJ_22252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        long sum = 0;
        while(n-->0) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            if(query == 1) {
                String name = st.nextToken();
                int k = Integer.parseInt(st.nextToken());
                while(k-->0) {
                    int num = Integer.parseInt(st.nextToken());
                    PriorityQueue<Integer> pq;
                    if(map.containsKey(name)) {
                        pq = map.get(name);
                    }else {
                        pq = new PriorityQueue<>((o1, o2)->o2-o1);
                    }
                    pq.add(num);
                    map.put(name, pq);
                }
            }else if(query == 2) {
                String name = st.nextToken();
                int b = Integer.parseInt(st.nextToken());
                if(map.containsKey(name)) {
                    if(map.get(name).size()>=b) {
                        while(b-->0) {
                            int pop = map.get(name).poll();
                            sum += pop;
                        }
                    }else {
                        while(!map.get(name).isEmpty()) {
                            int pop = map.get(name).poll();
                            sum += pop;
                        }
                    }
                }
            }
        }

        System.out.println(sum);
    }

}
