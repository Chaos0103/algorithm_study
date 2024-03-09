import java.util.*;
class Solution {
    static class Pair{
        int x;
        int y;
        int move;
        Pair(int x, int y, int move){
            this.x=x;
            this.y=y;
            this.move = move;
        }
    }
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static String arr[][];
    static boolean v[][];
    static int goalX, goalY, minCount = Integer.MAX_VALUE;
    public int solution(String[] board) {
        int answer = 0;

        arr = new String[board.length][board[0].length()];
        v = new boolean[board.length][board[0].length()];
        for(int i=0;i<board.length;i++){
            String s = board[i];
            for(int j=0;j<s.length();j++){
                arr[i][j] = s.substring(j, j+1);

                if(arr[i][j].equals("G")){
                    goalX = i; goalY = j;
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length();j++){
                if(arr[i][j].equals("R")){
                    find(i, j, 0);
                }
            }
        }


        return minCount;
    }

    public static int find(int x, int y, int cnt){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y, cnt));

        while(!q.isEmpty()){
            Pair now = q.poll();
            v[now.x][now.y] = true;

            for(int dir=0;dir<dx.length;dir++){
                int nx = now.x+dx[dir];
                int ny = now.y+dy[dir];

                if(nx<0 || nx>=arr.length || ny<0 || ny>=arr.length) continue;

                while( check(nx, ny, dir) ){
                    nx += dx[dir];
                    ny += dy[dir];
                }

                if(nx == goalX && ny == goalY){
                    return now.move+1;
                }else{
                    if(now.move+1 > minCount) continue;
                    q.add(new Pair(nx, ny, now.move+1));
                }
            }
        }
        return -1;
    }
    public static boolean check(int nx, int ny, int dir){
        if(nx+dx[dir] <0 || ny+dy[dir]<0 || nx+dx[dir]>=arr.length || ny+dy[dir]>=arr.length || arr[nx+dx[dir]][ny+dy[dir]].equals("D")){
            return false;
        }
        return true;
    }
}