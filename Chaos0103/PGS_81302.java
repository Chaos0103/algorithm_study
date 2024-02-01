import java.util.*;

class Solution {

    private static final int[] dy = {0, 0, 1, -1};
    private static final int[] dx = {1, -1, 0, 0};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        Arrays.fill(answer, 1);

        for (int i = 0; i < 5; i++) {
            char[][] arr = toArray(places[i]);
            for (int y = 0; y < 5; y++) {
                for (int x = 0; x < 5; x++) {
                    if (arr[y][x] == 'P' && !bfs(new int[]{y, x}, arr)) {
                        answer[i] = 0;
                    }
                }
            }
        }

        return answer;
    }

    private boolean bfs(int[] position, char[][] arr) {
        int[][] result = new int[5][5];

        Queue<int[]> q = new LinkedList<>();
        q.offer(position);

        while (!q.isEmpty()) {
            int[] current = q.poll();
            if (result[current[0]][current[1]] >= 2) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];
                if (ny < 0 || 5 <= ny || nx < 0 || 5 <= nx) {
                    continue;
                }

                if (result[ny][nx] != 0) {
                    continue;
                }

                if (arr[ny][nx] == 'X') {
                    continue;
                }

                if (!(position[0] == ny && position[1] == nx) && arr[ny][nx] == 'P') {
                    return false;
                }
                
                result[ny][nx] = result[current[0]][current[1]] + 1;
                q.offer(new int[]{ny, nx});
            }
        }

        return true;
    }

    private char[][] toArray(String[] place) {
        char[][] arr = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = place[i].charAt(j);
            }
        }
        return arr;
    }
}
