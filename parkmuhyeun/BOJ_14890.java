import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        N = Integer.parseInt(first[0]);
        L = Integer.parseInt(first[1]);

        int[][] arr = new int[N][N];
        boolean[][] checked = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }

        int res = 0;

        for (int r = 0; r < N; r++) {
            if (isRowCross(r, arr, checked)) {
                res++;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                checked[i][j] = false;
            }
        }

        for (int c = 0; c < N; c++) {
            if (isColumnCross(c, arr, checked)) {
                res++;
            }
        }

        System.out.println(res);
    }

    private static boolean isRowCross(int r, int[][] arr, boolean[][] checked) {
        int prev = arr[r][0];
        for (int j = 1; j < N; j++) {
            int now = arr[r][j];
            if (Math.abs(now - prev) >= 2) {
                return false;
            } else if (Math.abs(now - prev) == 1) {
                if (now > prev) {
                    if (j - L < 0) {
                        return false;
                    } else {
                        for (int i = j - L; i <= j - 1; i++) {
                            if (checked[r][i] || arr[r][i] != now - 1) {
                                return false;
                            }
                            checked[r][i] = true;
                        }
                    }
                } else {
                    if (j + L - 1 >= N) {
                        return false;
                    } else {
                        for (int i = j; i <= j + L - 1; i++) {
                            if (checked[r][i] || arr[r][i] != now) {
                                return false;
                            }
                            checked[r][i] = true;
                        }
                    }
                }
            }
            prev = now;
        }
        return true;
    }

    private static boolean isColumnCross(int c, int[][] arr, boolean[][] checked) {
        int prev = arr[0][c];
        for (int j = 1; j < N; j++) {
            int now = arr[j][c];
            if (Math.abs(now - prev) >= 2) {
                return false;
            } else if (Math.abs(now - prev) == 1) {
                if (now > prev) {
                    if (j - L < 0) {
                        return false;
                    } else {
                        for (int i = j - L; i <= j - 1; i++) {
                            if (checked[i][c] || arr[i][c] != now - 1) {
                                return false;
                            }
                            checked[i][c] = true;
                        }
                    }
                } else {
                    if (j + L - 1 >= N) {
                        return false;
                    } else {
                        for (int i = j; i <= j + L - 1; i++) {
                            if (checked[i][c] || arr[i][c] != now) {
                                return false;
                            }
                            checked[i][c] = true;
                        }
                    }
                }
            }
            prev = now;
        }
        return true;
    }
}
