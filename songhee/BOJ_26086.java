import java.io.*;
import java.util.*;
class BOJ_26086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean flag = true;
        Deque<Integer> d = new LinkedList<>();
        while(Q-- >0) {
            st = new StringTokenizer(br.readLine());
            int bot = Integer.parseInt(st.nextToken());

            if(bot == 0) {
                int num = Integer.parseInt(st.nextToken());
                if(flag) {
                    d.addFirst(num);
                }else {
                    d.addLast(num);
                }
            }else if(bot == 1) {
                List<Integer> list = new ArrayList<>(d);
                Collections.sort(list);
                d.clear();
                d.addAll(list);
            }else {
                flag = !flag;
            }
        }

        if(flag) {
            for(int i=1;i<K;i++) {
                d.poll();
            }
            System.out.println(d.poll());
        }else {
            for(int i=1;i<K;i++) {
                d.pollLast();
            }
            System.out.println(d.pollLast());
        }
    }
}