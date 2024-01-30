import java.util.*;
import java.io.*;
class BOJ_21610{
    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    //1  2  3   4   5  6  7  8
    static int dx[] = {0, -1,-1, -1, 0, 1, 1, 1};
    static int dy[] = {-1,-1, 0,  1, 1, 1, 0, -1};
    static int n, m, arr[][];
    static List<Pair> list = new ArrayList<>();
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list.add(new Pair(n-2, 0));
        list.add(new Pair(n-2, 1));
        list.add(new Pair(n-1, 0));
        list.add(new Pair(n-1, 1));


        while(m-->0) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken())-1;
            int num = Integer.parseInt(st.nextToken());

            firstStep(dir, num);
            secondStep();
            waterCopyMagic();
            waterLiterIncrease();
        }

        System.out.println(sum());

    }
    private static int sum() {
        int cnt = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                cnt+=arr[i][j];
            }
        }
        return cnt;
    }
    private static void waterLiterIncrease() {
        List<Pair> create = new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(arr[i][j]>=2 && hasCloud(i, j)) {
                    create.add(new Pair(i, j));
                    arr[i][j]-=2;
                }
            }
        }

        list.clear();
        list.addAll(create);

    }
    private static boolean hasCloud(int x, int y) {
        for(int i=0;i<list.size();i++) {
            Pair p = list.get(i);
            if(p.x == x && p.y == y) return false;
        }
        return true;
    }
    private static void waterCopyMagic() {

        for(int i=0;i<list.size();i++) {
            Pair p = list.get(i);
            int cnt = 0;
            for(int dir = 1;dir<8;dir+=2) {
                int nx = p.x+dx[dir];
                int ny = p.y+dy[dir];

                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                if(arr[nx][ny] >0) cnt++;
            }
            arr[p.x][p.y] += cnt;
        }

    }
    private static void secondStep() {
        for(int i=0;i<list.size();i++) {
            Pair p = list.get(i);
            arr[p.x][p.y]++;
        }
    }
    private static void firstStep(int dir, int num) {

        while(num-->0) {
            int size = list.size();
            for(int i=0;i<size;i++) {
                Pair p = list.get(i);
                int x = p.x + dx[dir];
                int y = p.y + dy[dir];

                if(x<0) {
                    x = n-1;
                }
                if(x>=n) {
                    x = 0;
                }
                if(y<0) {
                    y = n-1;
                }
                if(y>=n) {
                    y = 0;
                }

                list.set(i, new Pair(x, y));
            }

        }

    }

}