import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int result = Integer.MAX_VALUE;

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int minimumDistance(Point house, List<Point> choiceStores) {
        int minDistance = Integer.MAX_VALUE;
        for (Point store : choiceStores) {
            int distance = Math.abs(house.x - store.x) + Math.abs(house.y - store.y);
            minDistance = Math.min(minDistance, distance);
        }
        return minDistance;
    }

    private static void dfs(List<Point> stores, boolean[] isVisited, int start, int depth, int m, List<Point> houses) {
        if (depth == m) {
            List<Point> choiceStores = new ArrayList<>();
            for (int i = 0; i < stores.size(); i++) {
                if (isVisited[i]) {
                    choiceStores.add(stores.get(i));
                }
            }
            int totalDistance = 0;
            for (Point house : houses) {
                totalDistance += minimumDistance(house, choiceStores);
            }
            result = Math.min(result, totalDistance);
            return;
        }

        for (int i = start; i < stores.size(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(stores, isVisited, i + 1, depth + 1, m, houses);
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Point> houses = new ArrayList<>();
        List<Point> stores = new ArrayList<>();
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 1) {
                    houses.add(new Point(x, y));
                } else if (type == 2) {
                    stores.add(new Point(x, y));
                }
            }
        }

        dfs(stores, new boolean[stores.size()], 0, 0, m, houses);

        System.out.println(result);
    }
}
