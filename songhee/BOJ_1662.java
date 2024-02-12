import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Solution4 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        Stack<String> stk = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            if(!arr[i].equals(")")) {
                stk.push(arr[i]);
            }else {
                int cnt = 0;
                while(!stk.peek().equals("(")) {
                    String output = stk.pop();
                    if(output.equals("*")) {
                        int len = Integer.parseInt(stk.pop());
                        cnt += len;
                    }else {
                        cnt += 1;
                    }
                }
                stk.pop(); 
                int len = Integer.parseInt(stk.pop());
                cnt *= len; 
                stk.push(String.valueOf(cnt));
                stk.push("*");
            }
        }

        int ans = 0;
        while(!stk.isEmpty()) {
            if(stk.peek().equals("*")) {
                stk.pop();
                ans += Integer.parseInt(stk.pop());
            }else {
                stk.pop();
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}
