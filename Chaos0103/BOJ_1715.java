import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int card = Integer.parseInt(br.readLine());
            pq.add(card);
        }

        int result = 0;
        while (pq.size() > 1) {
            int card1 = pq.poll();
            int card2 = pq.poll();
            int sum = card1 + card2;
            result += sum;
            pq.add(sum);
        }

        System.out.println(result);
    }
}
