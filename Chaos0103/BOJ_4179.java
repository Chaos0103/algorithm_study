import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static class Point {
        public int y;
        public int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static int[][] fire(char[][] map, ArrayList<Point> fires) {
        int[][] result = new int[map.length][map[0].length];
        for (Point fire : fires) {
            result[fire.y][fire.x] = 1;
        }

        Queue<Point> q = new LinkedList<>(fires);

        while (!q.isEmpty()) {
            Point point = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = point.y + d[i][0];
                int nx = point.x + d[i][1];

                if (!(0 <= ny && ny < map.length && 0 <= nx && nx < map[0].length)) {
                    continue;
                }

                if (map[ny][nx] == '#') {
                    continue;
                }

                if (result[ny][nx] > 0) {
                    continue;
                }

                result[ny][nx] = result[point.y][point.x] + 1;
                q.add(new Point(ny, nx));
            }
        }

        return result;
    }

    private static int jihun(char[][] map, int[][] fire, Point jihun) {
        int[][] result = new int[map.length][map[0].length];
        result[jihun.y][jihun.x] = 1;

        Queue<Point> q = new LinkedList<>();
        q.add(jihun);

        while (!q.isEmpty()) {
            Point point = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = point.y + d[i][0];
                int nx = point.x + d[i][1];

                if (!(0 <= ny && ny < map.length && 0 <= nx && nx < map[0].length)) {
                    return result[point.y][point.x];
                }

                if (map[ny][nx] == '#') {
                    continue;
                }

                if (result[ny][nx] > 0) {
                    continue;
                }

                result[ny][nx] = result[point.y][point.x] + 1;
                if (fire[ny][nx] > 0 && result[ny][nx] >= fire[ny][nx]) {
                    continue;
                }

                q.add(new Point(ny, nx));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Point jihun = null;
        ArrayList<Point> fires = new ArrayList<>();

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'J') {
                    jihun = new Point(i, j);
                } else if (map[i][j] == 'F') {
                    fires.add(new Point(i, j));
                }
            }
        }

        int[][] fire = fire(map, fires);
        int result = jihun(map, fire, jihun);
        System.out.println(result > 0 ? result : "IMPOSSIBLE");
    }
}
