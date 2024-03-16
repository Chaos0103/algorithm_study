
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int arr[][];
    static int N = 1;
    static int blackLupi[][];
    static boolean v[][];
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
        StringBuilder sb = new StringBuilder();
        
        int idx = 1;
        while((N = Integer.parseInt(br.readLine())) != 0) {
        	
        	arr = new int[N][N];
        	v = new boolean[N][N];
        	blackLupi = new int[N][N];
        	
        	for(int i=0;i<N;i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0;j<N;j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	for(int i=0;i<N;i++) {
        		for(int j=0;j<N;j++) {
        			blackLupi[i][j] = 1000000000;
        		}
        	}
        	
        	sb.append("Problem "+idx+": "+escape(0, 0)+"\n");
        	idx++;
        	
        }
        
        System.out.println(sb);
             
        return;
        
	}
	private static int escape(int i, int j) {
		Queue<xy> q = new LinkedList<>();
		q.add(new xy(i, j));
		v[i][j] = true;
		blackLupi[i][j] = arr[i][j];
		
		while(!q.isEmpty()) {
			xy now = q.poll();
			for(int dir=0;dir<dx.length;dir++) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];
				
				if(isRange(nx, ny) && blackLupi[nx][ny] > blackLupi[now.x][now.y] + arr[nx][ny]) {
					blackLupi[nx][ny] = blackLupi[now.x][now.y] + arr[nx][ny]; 
					v[nx][ny] = true;
					q.add(new xy(nx, ny));
				}
			}
		}
		return blackLupi[N-1][N-1];
	}
	
	private static boolean isRange(int nx, int ny) {
		if(nx<0 || nx>=N || ny<0 || ny>=N) return false;
		return true;
	}
	
}
