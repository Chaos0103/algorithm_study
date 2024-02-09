import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Solution4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		Stack stack1 = new Stack<Integer>();
		Stack stack2 = new Stack<Integer>();
		Stack stack3 = new Stack<Integer>();
		Stack stack4 = new Stack<Integer>();
		
		while(st.hasMoreElements()) {
			int num = Integer.parseInt(st.nextToken());
			if(stack1.isEmpty() || (int)stack1.peek() < num) {
				stack1.push(num);
			}else {
				if(stack2.isEmpty()|| (int) stack2.peek() < num) {
					stack2.push(num);
				}else {
					if(stack3.isEmpty() || (int)stack3.peek() < num) {
						stack3.push(num);
					}else {
						if(stack4.isEmpty() || (int)stack4.peek() < num) {
							stack4.push(num);
						}else {
							System.out.println("NO");
							return;
						}
					}
				}
			}
		}
		
		while(n>0) {
			if(!stack1.isEmpty() && (int)stack1.peek() == n) {
				stack1.pop();
				n--;
			}else if(!stack2.isEmpty() && (int)stack2.peek() == n) {
				stack2.pop();
				n--;
			}
			else if(!stack3.isEmpty() && (int)stack3.peek() == n) {
				stack3.pop();
				n--;
			}else if(!stack4.isEmpty() && (int)stack4.peek() == n) {
				stack4.pop();
				n--;
			}
		}
		System.out.println("YES");
	}
}
