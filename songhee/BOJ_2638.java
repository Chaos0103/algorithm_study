import java.io.*;
import java.util.*;
class Main {
    static boolean visit[][], outerAir[][], outerVisit[][];
    static int dx[] = {1,0,-1,0}, dy[] = {0,1,0,-1};
    static int arr[][], N, M, time;
    static List<xy> list = new ArrayList<>();
    static class xy{
        int x;
        int y;
        xy(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            time++;
            visit = new boolean[N][M];
            outerAir = new boolean[N][M];
            outerVisit = new boolean[N][M];

            checkOuterAir();

            for(int i =0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(!visit[i][j] && arr[i][j] == 1 && hasAroundAir(i, j)) {
                        dfs(i, j);
                    }
                }
            }

            for(int i=0;i<list.size();i++) {
                xy now = list.get(i);
                arr[now.x][now.y] = 0;
            }

            boolean flag = true;
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(arr[i][j] != 0) {
                        flag = false;
                    }
                }
            }

            if(flag) {
                System.out.println(time);
                return;
            }
        }

    }
    private static void checkOuterAir() {
        Queue<xy> q = new LinkedList<>();
        q.add(new xy(0,0));
        if(arr[0][0] == 0) {
            outerAir[0][0] = true;
        }

        while(!q.isEmpty()) {
            xy now = q.poll();

            for(int dir=0;dir<dx.length;dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];

                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(arr[nx][ny] == 0 && outerAir[nx][ny] == false) {
                    outerAir[nx][ny] = true;
                    q.add(new xy(nx, ny));
                }
            }
        }
    }
    private static boolean hasAroundAir(int i, int j) {
        int count = 0;
        for(int dir = 0;dir<dx.length;dir++) {
            int nx = i + dx[dir];
            int ny = j + dy[dir];

            if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
            if(arr[nx][ny] == 0 && outerAir[nx][ny] == true) {
                count++;
            }
        }

        if(count>=2) {
            return true;
        }
        return false;
    }
    private static void dfs(int x, int y) {
        Queue<xy> q = new LinkedList<>();
        q.add(new xy(x, y));
        visit[x][y] = true;
        list.add(new xy(x, y));

        while(!q.isEmpty()) {
            xy now = q.poll();
            for(int dir=0;dir<dx.length;dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];

                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(!visit[nx][ny] && arr[nx][ny] == 1 && hasAroundAir(nx, ny)) {
                    visit[nx][ny] = true;
                    list.add(new xy(nx, ny));
                    q.add(new xy(nx, ny));
                }
            }
        }
    }
}