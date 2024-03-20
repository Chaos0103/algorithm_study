import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] directions = {{}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    //1. 모든 구름이 di 방향으로 si칸 이동
    private static boolean[][] moveCloud(boolean[][] isCloud, int n, int d, int s) { // s%n
        boolean[][] isMovedCloud = new boolean[n][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (isCloud[y][x]) {
                    int ny = ((y + directions[d][0] * s) + n) % n;
                    int nx = ((x + directions[d][1] * s) + n) % n;
                    isMovedCloud[ny][nx] = true;
                }
            }
        }
        return isMovedCloud;
    }

    //2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가
    private static void rain(int[][] buckets, boolean[][] isCloud, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isCloud[i][j]) {
                    buckets[i][j]++;
                }
            }
        }
    }

    //3. 구름이 모두 사라짐

    //4. 2에서 물이 증가한 칸에 물복사 버그 -> 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수 만큼 물의 양 증가
    //4-1. 경계를 넘어서는 칸은 제외
    private static void copyWater(int[][] buckets, boolean[][] isCloud, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isCloud[i][j]) {
                    int count = checkBucket(buckets, i, j, n);
                    buckets[i][j] += count;
                }
            }
        }
    }

    private static int checkBucket(int[][] buckets, int y, int x, int n) {
        int count = 0;
        for (int i = 2; i < directions.length; i += 2) {
            int ny = y + directions[i][0];
            int nx = x + directions[i][1];

            if (!(0 <= ny && ny < n && 0 <= nx && nx < n)) {
                continue;
            }

            if (buckets[ny][nx] == 0) {
                continue;
            }

            count++;
        }

        return count;
    }

    //5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생성, 물의 양 2 감소
    //5-1. 3에서 구름이 사라진 칸이 아니여야 함
    private static boolean[][] mackCould(int[][] buckets, boolean[][] isCloud, int n) {
        boolean[][] isNextCloud = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isCloud[i][j]) {
                    continue;
                }

                if (buckets[i][j] < 2) {
                    continue;
                }

                isNextCloud[i][j] = true;
                buckets[i][j] -= 2;
            }
        }
        return isNextCloud;
    }

    private static int getTotalWater(int[][] buckets) {
        int total = 0;
        for (int[] bucket : buckets) {
            for (int water : bucket) {
                total += water;
            }
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] buckets = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                buckets[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] isCould = new boolean[n][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                isCould[n - 1 - i][j] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            boolean[][] isMovedCloud = moveCloud(isCould, n, d, s % n);
            rain(buckets, isMovedCloud, n);
            copyWater(buckets, isMovedCloud, n);
            isCould = mackCould(buckets, isMovedCloud, n);
        }

        int result = getTotalWater(buckets);
        System.out.println(result);
    }

}
