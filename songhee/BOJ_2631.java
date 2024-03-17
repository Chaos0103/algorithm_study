import java.io.*;
import java.util.*;
class Main {
	static int N, count;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	List<Integer> list = new ArrayList<>();
    	list.add(0);
    	for(int i=0;i<N;i++) {
    		list.add(Integer.parseInt(br.readLine()));
    	}
    	
    	int k = N;
    	if(list.get(k) != k) {
    		for(int i=1;i<=list.size();i++) {
    			if(list.get(i) == k) {
    				list.remove(i);
    				list.add(k, k);
    				count++;
    				break;
    			}
    		}
    	}
    	
    	k = 1;
    	while(k < N) {
    		if(list.get(k) != k) {
    			for(int i=1;i<=list.size();i++) {
    				if(list.get(i) == k) {
    					list.remove(i);
    					list.add(k, k);
    					count++;
    					break;
    				}
    			}
    		}
    		
    		k++;
    	}
    	
    	System.out.println(count);
    }	
}
