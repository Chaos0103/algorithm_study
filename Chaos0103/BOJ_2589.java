import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static class Point {
        public int x;
        public int y;
        public int time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    private static int bfs(char[][] map, int n, int m, int x, int y) {
        int result = 0;
        boolean[][] isVisited = new boolean[n][m];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 0));
        isVisited[y][x] = true;

        while (!q.isEmpty()) {
            Point point = q.poll();
            result = Math.max(result, point.time);

            for (int i = 0; i < 4; i++) {
                int ny = point.y + d[i][0];
                int nx = point.x + d[i][1];

                if (!(0 <= ny && ny < n && 0 <= nx && nx < m)) {
                    continue;
                }

                if (isVisited[ny][nx]) {
                    continue;
                }

                if (map[ny][nx] == 'W') {
                    continue;
                }

                isVisited[ny][nx] = true;
                q.add(new Point(nx, ny, point.time + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for (int y = 0; y < n; y++) {
            String line = br.readLine();
            for (int x = 0; x < m; x++) {
                map[y][x] = line.charAt(x);
            }
        }

        int result = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x] == 'L') {
                    int time = bfs(map, n, m, x, y);
                    result = Math.max(result, time);
                }
            }
        }

        System.out.println(result);
    }
}
