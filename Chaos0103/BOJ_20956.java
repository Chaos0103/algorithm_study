import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        input = br.readLine();
        st = new StringTokenizer(input);
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int quantity = Integer.parseInt(st.nextToken());
            map.putIfAbsent(quantity, new LinkedList<>());
            Deque<Integer> dq = map.get(quantity);
            dq.offer(i + 1);
        }

        Set<Integer> set = map.keySet();
        List<Integer> quantities = new ArrayList<>(set);
        quantities.sort((v1, v2) -> v2 - v1);

        boolean flag = false;
        for (int quantity : quantities) {
            Deque<Integer> index = map.get(quantity);
            while (!index.isEmpty()) {
                if (m-- == 0) {
                    break;
                }

                if (flag) {
                    sb.append(index.pollLast()).append("\n");
                } else {
                    sb.append(index.pollFirst()).append("\n");
                }

                if (quantity % 7 == 0) {
                    flag = !flag;
                }
            }
            if (m <= 0) {
                break;
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
