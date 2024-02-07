import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static public int[] solution(int m, int n, int[][] picture) {
        int[] dirX = {-1, 1, 0,0};
        int[] dirY = {0, 0, -1, 1};
        int[][] check = new int[m][n];
        Queue<Pos> queue = new LinkedList<>();
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                check[i][j] = 0;
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(check[i][j] != 0 || picture[i][j] == 0)
                    continue;

                queue.add(new Pos(i,j));
                check[i][j] = 1;
                numberOfArea++;
                int area = 0;

                while (!queue.isEmpty()) {
                    Pos remove = queue.remove();
                    int dx = remove.x;
                    int dy = remove.y;
                    area++;
                    for (int k = 0; k < 4; k++) {
                        Pos nextpos = new Pos(dx+dirX[k], dy+dirY[k]);
                        if (0 <= nextpos.x && nextpos.x < m && 0 <= nextpos.y && nextpos.y < n
                                && picture[dx][dy] == picture[nextpos.x][nextpos.y] && check[nextpos.x][nextpos.y] == 0) {
                            queue.add(new Pos(nextpos.x, nextpos.y));
                            check[nextpos.x][nextpos.y] = 1;
                        }
                    }
                }
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void main(String[] args) {
        int[][] picture = {};
//        picture = new int[][]{{1,1,1,0},  {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
        picture = new int[][]{{0,1,0}, {1,1,0}, {0,0,0}};
        int[] solution = solution(3, 3, picture);
        System.out.println("" + solution[0] + " " +solution[1]);

    }
}

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}