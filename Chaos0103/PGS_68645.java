import java.util.Scanner;

class Solution {

    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    public int[] solution(int n) {
        if (n == 1) {
            return new int[]{1};
        }
        
        int[][] arr = new int[n][n];
        int num = 1;
        int x = 0;
        int y = 0;
        int d = 0;
        while (arr[y][x] == 0) {
            arr[y][x] = num++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || n <= nx || ny < 0 || n <= ny || arr[ny][nx] != 0) {
                d = (d + 1) % 3;
            }
            x += dx[d];
            y += dy[d];
        }

        int[] answer = new int[num - 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                answer[index++] = arr[i][j];
            }
        }

        return answer;
    }
}
