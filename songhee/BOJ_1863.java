import java.io.*;
import java.util.*;
public class BOJ_1863 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int arr[][] = new int[n][2];
        for(int i=0;i<n;i++) {
            String[] s = br.readLine().split(" ");
            for(int j=0;j<2;j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        for(int i=0;i<n;) {
            if(stack.isEmpty()) {
                if(arr[i][1] != 0) {
                    stack.push(arr[i][1]);
                    i++;
                }else i++;
            }else {
                int y = arr[i][1];

                while(stack.peek() == y && i<n-1) {
                    y = arr[++i][1];
                }
                if(stack.peek() < y) {
                    stack.push(y);
                    i++;
                }else if(stack.peek() > y) {
                    answer++;
                    stack.pop();
                }

            }

        }

        if(!stack.isEmpty()) {
            answer+=stack.size();
        }

        System.out.println(answer);

    }
}
