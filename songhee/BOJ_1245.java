import java.util.*;
import java.io.*;
public class BOJ_1245 {
    static class Point{
        int r;
        int c;
        public Point(int r,int c) {
            this.r=r;
            this.c=c;
        }
    }
    static int R,C;
    static int arr[][];
    static int answer;
    static int dr[]= {-1,-1,-1,0,0,1,1,1};
    static int dc[]= {-1,0,1,-1,1,-1,0,1};
    static boolean visit[][];
    static boolean top[][];
    static Queue<Point> queue;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());

        arr=new int[R][C];
        visit = new boolean[R][C];
        top=new boolean[R][C];
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(arr[i][j]!=0 && top[i][j]==false) { //0이아니고 산봉우리로 확인 안된 곳에서만 bfs실행
                    bfs(i,j); // bfs를통해 (i,j)좌표가 산봉우리 인지 아닌지를 확인
                }
            }
        }

        System.out.println(answer);


    }

    static public void bfs(int r, int c) { // (r,c)지점이 산봉우리가 맞는지 확인하는 bfs
        visit = new boolean[R][C];
        visit[r][c]=true;
        queue = new ArrayDeque<Point>();
        queue.add(new Point(r,c));
        ArrayList<Point> topList = new ArrayList<Point>();// (r,c)가 산봉우리가 맞다면 이와 높이가 같아서 같은 산봉우리에 속하는 좌표들을 담아놓을 리스트
        while(!queue.isEmpty()) {
            Point cur = queue.poll();

            for(int d=0; d<8; d++) {
                int nr = cur.r+dr[d];
                int nc= cur.c+dc[d];
                if(nr>=0 && nc>=0 && nr<R && nc<C && visit[nr][nc]==false) {

                    if(arr[nr][nc]>arr[cur.r][cur.c]) //bfs시작지점(r,c)보다 높은곳이 있으면 (r,c)는 산봉우리가 아니므로 리턴해주면 됨.
                        return;
                    else if(arr[nr][nc]==arr[cur.r][cur.c]) { // 인접한 격자 중 높이가 같은 경우
                        queue.add(new Point(nr,nc));
                        topList.add(new Point(nr,nc));
                    }

                    visit[nr][nc]=true;
                }
            }
        }
        for(int i=0; i<topList.size(); i++) { //인접한 격자 중 높이가 같은것은 같은 산봉우리로 취급되어야 하므로 산봉우리 체크
            Point cur = topList.get(i);
            top[cur.r][cur.c]=true;
        }
        answer++;  // 여기까지 왔다면 bfs의 시작점인 (r,c)지점은 산봉우리 이므로 정답 1 증가
    }

}