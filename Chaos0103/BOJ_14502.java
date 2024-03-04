import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int result = 0;

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int safeArea(int[][] map, int n, int m) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void infection(int[][] map, int x, int y, int n, int m) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point point = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + d[i][0];
                int ny = point.y + d[i][1];

                if (!(0 <= ny && ny < n && 0 <= nx && nx < m)) {
                    continue;
                }

                if (map[ny][nx] != 0) {
                    continue;
                }

                map[ny][nx] = 2;
                q.add(new Point(nx, ny));
            }
        }
    }

    private static void generateWall(int[][] map, int depth, int n, int m) {
        if (depth == 3) {
            int[][] copyMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                System.arraycopy(map[i], 0, copyMap[i], 0, m);
            }

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (copyMap[y][x] == 2) {
                        infection(copyMap, x, y, n, m);
                    }
                }
            }

            int safeArea = safeArea(copyMap, n, m);
            result = Math.max(result, safeArea);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    generateWall(map, depth + 1, n, m);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        generateWall(map, 0, n, m);

        System.out.println(result);
    }
}
