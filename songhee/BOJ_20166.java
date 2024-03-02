import java.io.*;
import java.util.*;
class Main {
    static int dx[] = {1,0,-1,0, -1, -1, 1, 1}, dy[] = {0,1,0,-1, -1, 1, -1, 1};
    static int N, M, likeNums, count;
    static char arr[][];
    static String wantToFindString;
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
        likeNums = Integer.parseInt(st.nextToken());
        arr = new char[N][M];

        for(int i=0;i<N;i++) {
            String s = br.readLine();
            for(int j=0;j<M;j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        while(likeNums-->0) {
            count = 0;
            wantToFindString = br.readLine();
            char ch = wantToFindString.charAt(0);
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(ch == arr[i][j]) {
                        dfs(new StringBuilder().append(ch), i, j);
                    }
                }
            }

            sb.append(count+"\n");
        }

        System.out.println(sb);
    }
    private static void dfs(StringBuilder sb, int x, int y) {
        if(sb.length() == wantToFindString.length()) {
            if(sb.toString().equals(wantToFindString)) {
                count++;
            }
            sb.delete(sb.length()-1, sb.length());
            return;
        }

        for(int dir=0;dir<dx.length;dir++) {
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            if(nx<0 && ny<0) {
                nx = N-1; ny = M-1;
            }else if(nx>=N && ny>=M) {
                nx = 0; ny = 0;
            }else {
                if(nx<0) {
                    nx = N-1;
                }else if(nx>=N) {
                    nx = 0;
                }
                if(ny<0) {
                    ny = M-1;
                }else if(ny>=M) {
                    ny = 0;
                }

            }

            if(wantToFindString.charAt(sb.length()) == arr[nx][ny]) {
                dfs(sb.append(arr[nx][ny]), nx, ny);
            }
        }
    }
}