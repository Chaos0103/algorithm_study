import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int arr[][], N, M, k, order[];
    static int command[][];
    static int dx[] = {1, 0, -1, 0}, dy[] = {0, 1, 0, -1};
    static boolean commv[];
    static int minSum = 5000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        command = new int[k][3];
        order = new int[k];
        commv = new boolean[k];
        
        for(int i=0;i<k;i++) {
        	st = new StringTokenizer(br.readLine());
        	command[i][0] = Integer.parseInt(st.nextToken());
        	command[i][1] = Integer.parseInt(st.nextToken());
        	command[i][2] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0);
         
        System.out.println(minSum);
    }
    private static void dfs(int num) {
    	if(num == k) {
    		moving();
    		sum();
    		return;
    	}
    	
    	for(int i=0;i<k;i++) {
    		if(!commv[i]) {
    			commv[i] = true;
    			order[num] = i;
    			dfs(num+1);
    			commv[i] = false;
    		}
    	}
	}
	private static void sum() {
		for(int i=1;i<=N;i++) {
			int s = 0;
			for(int j=1;j<=M;j++) {
				s+= arr[i][j];
			}
			minSum = Math.min(minSum, s);
		}
	}
	private static void moving() {
		for(int i=0;i<k;i++) {
			int n = order[i];
			int r = command[n][0];
			int c = command[n][1];
			int s = command[n][2];
			
			int tmp = arr[r-s][c-s];
			int standX = r-s; int standY = c-s;
			int x = r-s; int y = c-s;
			for(int dir = 0; dir<dx.length;) {
				int nx = x+dx[dir];
				int ny = y+dy[dir];
				
				if(nx<r-s || nx>r+s || ny<c-s || ny>c+s) {
					dir++;
				}
				
				arr[x][y] = arr[nx][ny];
				
				if(nx == standX && ny == standY) {
					arr[x][y] = tmp;
					standX ++; standY++;
					x++; y++;
					dir = 0;
					tmp = arr[x][y];
				}
				
				if(standX == r && standY == c) {
					break;
				}
			}
		}
		
	}
}
