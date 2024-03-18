import java.io.*;
import java.util.*;
class Main {
	static int N, maxLen;
	static String[] arr, ans;
	static String[] result;
	static boolean[] v;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	arr = new String[N];
    	ans = new String[2];
    	result = new String[2];
    	v = new boolean[N];
    	for(int i=0;i<N;i++) {
    		arr[i] = br.readLine();
    	}
    	
    	allFind(0, 0);
    	
    	System.out.println(result[0]+"\n"+result[1]);
    }
	private static void allFind(int num, int idx) {
		if(num == 2) {
			int sum = 0;
			if(ans[0].length()>=ans[1].length()
					&& !ans[0].equals(ans[1])) {
				for(int i=0;i<ans[1].length();i++) {
					if(ans[0].charAt(i) == ans[1].charAt(i)) {
						sum++;
					}else {
						break;
					}
				}
				
			}else if(ans[0].length() < ans[1].length() &&
					!ans[0].equals(ans[1])) {
				for(int i=0;i<ans[0].length();i++) {
					if(ans[0].charAt(i) == ans[1].charAt(i)) {
						sum++;
					}else {
						break;
					}
				}
			}
			
			if(sum > maxLen) {
				maxLen = sum;
				result[0] = ans[0];
				result[1] = ans[1];
			}
			return;
		}

		for(int i=idx;i<N;i++) {
			if(!v[i]) {
				v[i] = true;
				ans[num] = arr[i];
				allFind(num+1, i+1);
				v[i] = false;
			}
		}
	}
	
}
