import java.io.*;
import java.util.*;
class Main {
    static int dx[] = {0,0,-1,1}, dy[] = {1,-1,0,0};
    //동서북남
    static int dice[] = {0,0,0,0,0,0};
    static int arr[][];
    static int N, M, x, y, numOfOrder, now;
    static int order[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        numOfOrder = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order = new int[numOfOrder];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<numOfOrder;i++) {
            moving(Integer.parseInt(st.nextToken()));
            sb.append(dice[2]+"\n");
        }

        System.out.println(sb);
    }
    private static void moving(int direction) {
        int nx = x + dx[direction-1];
        int ny = y + dy[direction-1];
        if(nx<0 || nx>=N || ny<0 || ny>=M) return;
        x = nx;
        y = ny;
        diceMoving(direction, nx, ny);
    }
    /*
     *    0
     *   123
     *    4
     *    5
     *    윗면이 2, 아랫면이 5, 동서북남
     * */
    private static void diceMoving(int direction, int nx, int ny) {
        int tmp = dice[2];
        if(direction == 1) {
            //5->3, 3->2, 2->1, 1->5
            dice[2] = dice[3];
            dice[3] = dice[5];
            dice[5] = dice[1];
            dice[1] = tmp;
        }else if(direction == 2) {
            //5->1, 1->2, 2->3, 3->5,
            dice[2] = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[3];
            dice[3] = tmp;
        }else if(direction == 3) {
            //5->4,  4->2, 2->0, 0->5
            dice[2] = dice[4];
            dice[4] = dice[5];
            dice[5] = dice[0];
            dice[0] = tmp;
        }else if(direction == 4) {
            //4->5, 5->0, 0->2, 2->4
            dice[2] = dice[0];
            dice[0] = dice[5];
            dice[5] = dice[4];
            dice[4] = tmp;
        }

        if(arr[x][y] == 0) {
            arr[x][y] = dice[5];
        }else {
            dice[5] = arr[x][y];
            arr[x][y] = 0;
        }

    }

}