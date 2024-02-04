import java.io.*;
import java.util.*;
public class BOJ_6643 {
    static char[] arr;
    static int size;
    static Stack<Character> stack;
    static StringBuilder gsb = new StringBuilder();
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(n-->0) {
            String s = br.readLine();
            size = s.length();
            arr = new char[26];
            stack = new Stack<>();
            for(int i=0;i<size;i++) {
                arr[s.charAt(i) - 'a']++;
            }
            find(0);

            stack = new Stack<>();
        }
        System.out.println(gsb);
    }
    private static void find(int i) {
        if(i == size) {
            StringBuilder sb = new StringBuilder();
            for(char c : stack) {
                sb.append(c);
            }

            gsb.append(sb.toString()+"\n");
            return;
        }

        for(int j=0;j<arr.length;j++) {
            if(arr[j]>0) {
                arr[j]--;
                stack.push((char) ('a'+j));
                find(i+1);
                stack.pop();
                arr[j]++;
            }
        }
    }

}
