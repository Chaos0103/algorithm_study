import java.io.*;
import java.util.*;
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public static int arr[][], answer[];
    public static List<Integer> list = new ArrayList<>();
    public static boolean visit[][];

    public static Queue<Pair> q = new LinkedList<>();
    public static int dx[] = {1,0,-1,0}, dy[] = {0,1,0,-1};
    public int[] solution(String[] maps) {
        visit = new boolean [maps.length][maps[0].length()];
        arr = new int[maps.length][maps[0].length()];

        for(int i=0;i<maps.length;i++){
            String s = maps[i];
            for(int j=0;j<maps[0].length();j++){
                if(s.charAt(j) == 'X') arr[i][j] = -1;
                else arr[i][j] = s.charAt(j) - '0';

            }
        }



        for(int i=0;i<maps.length;i++){

            for(int j=0;j<maps[0].length();j++){

                if(visit[i][j] == false && arr[i][j] != -1){
                    visit[i][j] = true;
                    q.add(new Pair(i, j));
                    bfs(maps.length, maps[0].length());
                }
            }
        }



        Collections.sort(list);

        if(list.size() == 0){
            answer = new int[1];
            answer[0] = -1;
        }else{

            answer = new int[list.size()];

            for(int i=0;i<list.size();i++){
                answer[i] = list.get(i);
            }
        }


        return answer;
    }
    public static void bfs(int a, int b){
        int sum = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            sum += arr[p.x][p.y];

            for(int dir = 0;dir<4;dir++){
                int nx = p.x + dx[dir];
                int ny = p.y + dy[dir];

                if(nx<0 || nx>=a || ny<0 || ny>=b) continue;
                if(visit[nx][ny] == true) continue;
                if(arr[nx][ny] == -1) continue;

                q.add(new Pair(nx, ny));
                visit[nx][ny] = true;

            }
        }

        list.add(sum);
        System.out.println(sum);
    }
}