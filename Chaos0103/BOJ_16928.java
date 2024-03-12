import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    private static class Player {
        public int index;
        public int count;

        public Player(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    private static int gameRun(int[] map) {
        boolean[] isVisited = new boolean[101];
        isVisited[1] = true;

        Queue<Player> q = new LinkedList<>();
        q.add(new Player(1, 0));

        while (!q.isEmpty()) {
            Player player = q.poll();

            for (int i = 1; i <= 6; i++) {
                int next = player.index + i;

                if (100 < next) {
                    continue;
                }

                if (next == 100) {
                    return player.count + 1;
                }

                if (isVisited[next]) {
                    continue;
                }

                q.add(new Player(map[next], player.count + 1));
                isVisited[next] = true;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] map = IntStream.range(0, 101)
            .toArray();

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a] = b;
        }

        int result = gameRun(map);
        
        System.out.println(result);
    }
}
