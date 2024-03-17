
import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
    static int arr[][];
    static int N, L, R, idx, days;
    static boolean noMore;
    static boolean v[][];
    static class xy{
    	int x;
    	int y;
    	xy(int x, int y){
    		this.x=x;
    		this.y=y;
    	}
    }
    static int dx[] = {1,0, -1, 0}, dy[] = {0,1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        arr = new int[N][N];
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        while(true) {
        	v = new boolean[N][N];
        	noMore = true;
        	idx = 1;
        	int num = 0;
        	for(int i=0;i<N;i++) {
        		for(int j=0;j<N;j++) {
        			if(!v[i][j]) {
        				num += bfs(i, j);
        			}
        		}
        	}
        	if(noMore == true) {
        		System.out.println(days);
        		return;
        	}
        	days++;
        	
        }
        
	}
	private static int bfs(int i, int j) {
		Queue<xy> q = new LinkedList<>();
		List<xy> list = new ArrayList<>();
		q.add(new xy(i, j));
		list.add(new xy(i, j));
		v[i][j] = true;
		int miniSum = arr[i][j];
		
		while(!q.isEmpty()) {
			xy now = q.poll();
			for(int dir=0;dir<dx.length;dir++) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];
				
				if(isRange(nx, ny) && canMakeOne(new xy(now.x, now.y), new xy(nx, ny)) && v[nx][ny] == false) {
					v[nx][ny] = true;
					miniSum += arr[nx][ny];
					list.add(new xy(nx, ny));
					q.add(new xy(nx, ny));
				}
			}
		}
		
		if(list.size() == 1) {
			return 1;
		}else {
			noMore = false;
		}
		
		int people = miniSum / list.size();
		for(int k=0;k<list.size();k++) {
			xy now = list.get(k);
			arr[now.x][now.y] = people;
		}
		return miniSum;
	}
	
	private static boolean canMakeOne(xy xy, xy xy2) {
		int chai = Math.abs(arr[xy.x][xy.y] - arr[xy2.x][xy2.y]);
		if(chai >= L && chai <= R) {
			return true;
		}
		return false;
	}
	private static boolean isRange(int nx, int ny) {
		if(nx<0 || nx>=N || ny<0 || ny>=N) return false;
		return true;
	}
	
}
