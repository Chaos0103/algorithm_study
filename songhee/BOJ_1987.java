import java.io.*;
import java.util.*;
class BOJ_1987 {
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static int R, C, count=0;
    static char arr[][];
    static class xy{
        int x;
        int y;
        int sum;
        xy(int x, int y, int sum){
            this.x=x;
            this.y=y;
            this.sum = sum;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        for(int i=0;i<R;i++) {
            String s = br.readLine();
            for(int j=0;j<C;j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        List<Character> s = new ArrayList<>();
        boolean v[][] = new boolean[R][C];
        v[0][0] = true;
        s.add(arr[0][0]);
        dfs(0, 0, 0, s, v);

        System.out.println(count+1);
    }
    private static void dfs(int i, int j, int sum, List<Character> s, boolean v[][]) {


        for(int dir = 0;dir<dx.length;dir++) {
            int nx = i+dx[dir];
            int ny = j+dy[dir];
            if(nx<0 || nx>=R || ny<0 || ny>=C) {
                count = Math.max(count, sum);
                continue;
            }else if(v[nx][ny] == true || s.contains(arr[nx][ny])) {
                count = Math.max(count, sum);
                continue;
            }
            s.add(arr[nx][ny]);
            v[nx][ny] = true;
            dfs(nx, ny, sum+1, s, v);
            s.remove(sum+1);
            v[nx][ny] = false;
        }
    }
}