import java.io.*;
import java.util.*;
public class Solution4 {
    static class Condition{
        int x;
        int y;
        int direction;
        int duration;
        Condition(int x, int y, int direction){
            this.x=x;
            this.y=y;
            this.direction = direction;
            duration = 0;
        }
    }
    static int arr[][], count, n, dist[][];
    static int dx[] = {0,1,1};
    static int dy[] = {1,1,0};
    static int d0[] = {0,1};
    static int d1[] = {0,1,2};
    static int d2[] = {1,2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        for(int i=1;i<n+1;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<n+1;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dist = new int[n+1][n+1];

        dist[1][1] = 1;
        dist[1][2] = 1;
        find(1, 2);

        if(arr[n][n] == 1) System.out.println(0);
        else {
            find(1, 2);
            System.out.println(count);
        }
    }
    private static void find(int x, int y) {
        Queue<Condition> q = new LinkedList<>();
        q.add(new Condition(x, y, 0));

        boolean flag = false;
        while(!q.isEmpty()) {
            Condition now = q.poll();
            if(now.direction == 0) {
                for(int i = 0;i<d0.length;i++) {
                    int nx = now.x + dx[d0[i]];
                    int ny = now.y + dy[d0[i]];

                    if(nx<=0 || nx >= n+1 || ny<=0 || ny >=n+1) continue;
                    if(!check(nx, ny, d0[i])) continue;


                    if(nx == n && ny == n) {
                        count++;
                    }else {
                        q.add(new Condition(nx, ny, d0[i]));
                    }
                }
            }else if(now.direction == 1) {
                for(int i = 0;i<d1.length;i++) {
                    int nx = now.x + dx[d1[i]];
                    int ny = now.y + dy[d1[i]];

                    if(nx<=0 || nx >= n+1 || ny<=0 || ny >=n+1) continue;
                    if(!check(nx, ny, d1[i])) continue;

                    if(nx == n && ny == n) {
                        count++;
                    }else {
                        q.add(new Condition(nx, ny, d1[i]));
                    }
                }
            }else {
                for(int i = 0;i<d2.length;i++) {
                    int nx = now.x + dx[d2[i]];
                    int ny = now.y + dy[d2[i]];

                    if(nx<=0 || nx >= n+1 || ny<=0 || ny >=n+1) continue;
                    if(!check(nx, ny, d2[i])) continue;

                    if(nx == n && ny == n) {
                        count++;
                    }else {
                        q.add(new Condition(nx, ny, d2[i]));
                    }
                }
            }


        }

    }
    private static boolean check(int nx, int ny, int direction) {
        if(direction == 1) {
            if(arr[nx][ny] == 1 || arr[nx][ny-1] == 1 || arr[nx-1][ny] == 1) return false;
            else return true;
        }else {
            if(arr[nx][ny] == 1) return false;
            else return true;
        }
    }

}
