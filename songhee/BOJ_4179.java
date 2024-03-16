
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static char arr[][];
    static int R, C;
    static int fireTime[][], jihunTime[][];
    static boolean firev[][], jihunv[][];
    static class xy{
    	int x;
    	int y;
    	xy(int x, int y){
    		this.x=x;
    		this.y=y;
    	}
    }
    static int dx[] = {1,0,-1,0}, dy[] = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];

        fireTime = new int[R][C];
        jihunTime = new int[R][C];
        
        firev = new boolean[R][C];
        jihunv = new boolean[R][C];
        
        for(int i=0;i<R;i++) {
        	for(int j=0;j<C;j++) {
        		fireTime[i][j] = 1000000;
        	}
        }
        
        Queue<xy> q = new LinkedList<>();
        xy jihunPosition = null;
        for(int i=0;i<R;i++){
            String s = br.readLine();
            for(int j=0;j<C;j++){
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'F') {
                	fireTime[i][j] = 0;
                	firev[i][j] = true;
                	q.add(new xy(i, j));
                }else if(arr[i][j] == 'J') {
                	jihunPosition = new xy(i, j);
                }
            }
        }
        
        movingFire(q);
        
        System.out.println(escape(jihunPosition.x, jihunPosition.y));
          
        return;
        
	}
	private static String escape(int i, int j) {
		Queue<xy> q = new LinkedList<>();
		q.add(new xy(i, j));
		jihunTime[i][j] = 0;
		jihunv[i][j] = true;
		
		while(!q.isEmpty()) {
			xy now = q.poll();
			for(int dir=0;dir<dx.length;dir++) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];
				
				if(!isRange(nx, ny)) {
					return String.valueOf((jihunTime[now.x][now.y] + 1));
				}
				if(jihunCanMove(nx, ny) && jihunTime[now.x][now.y]+1 < fireTime[nx][ny] && jihunv[nx][ny] == false ) {
					jihunTime[nx][ny] = jihunTime[now.x][now.y] + 1;
					jihunv[nx][ny] = true;
					q.add(new xy(nx, ny));
				}
			}
		}
		
		
		return "IMPOSSIBLE";
	}
	private static boolean jihunCanMove(int nx, int ny) {
		if(arr[nx][ny] != '#' && arr[nx][ny] != 'F') {
			return true;
		}
		return false;
	}
	private static void movingFire(Queue<xy> first) {
		
		while(!first.isEmpty()) {
			xy now = first.poll();
			for(int dir=0;dir<dx.length;dir++) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];
				
				if(!isRange(nx, ny)) continue;
				if(hasRoad(nx, ny) && firev[nx][ny] == false) {
					firev[nx][ny] = true;
					fireTime[nx][ny] = fireTime[now.x][now.y] + 1; 
					first.add(new xy(nx, ny));
				}
			}
		}
	}
	private static boolean isRange(int nx, int ny) {
		if(nx<0 || nx>=R || ny<0 || ny>=C) return false;
		return true;
	}
	private static boolean hasRoad(int nx, int ny) {
		if(arr[nx][ny] != '#') {
			return true;
		}
		return false;
	}
}
