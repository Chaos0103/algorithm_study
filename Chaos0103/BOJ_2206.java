import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static class Point {
        public int x;
        public int y;
        public boolean isBreak;
        public int distance;

        public Point(int x, int y, boolean isBreak, int distance) {
            this.x = x;
            this.y = y;
            this.isBreak = isBreak;
            this.distance = distance;
        }
    }

    private static int bfs(int[][] map, int n, int m) {
        boolean[][][] isVisited = new boolean[n][m][2];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, false, 1));
        isVisited[0][0][0] = true;

        while (!q.isEmpty()) {
            Point point = q.poll();

            if (point.y == n - 1 && point.x == m - 1) {
                return point.distance;
            }

            int isBreak = point.isBreak ? 1 : 0;
            for (int i = 0; i < 4; i++) {
                int ny = point.y + d[i][0];
                int nx = point.x + d[i][1];
                
                if (!(0 <= ny && ny < n && 0 <= nx && nx < m)) {
                    continue;
                }

                if (map[ny][nx] == 1) {
                    if (!point.isBreak && !isVisited[ny][nx][1]) {
                        q.add(new Point(nx, ny, true, point.distance + 1));
                        isVisited[ny][nx][1] = true;
                    }
                    continue;
                }


                if (!isVisited[ny][nx][isBreak]) {
                    q.add(new Point(nx, ny, point.isBreak, point.distance + 1));
                    isVisited[ny][nx][isBreak] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int y = 0; y < n; y++) {
            String line = br.readLine();
            for (int x = 0; x < m; x++) {
                map[y][x] = line.charAt(x) - '0';
            }
        }

        int result = bfs(map, n, m);

        System.out.println(result);
    }
}
