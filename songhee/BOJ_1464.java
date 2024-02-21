import java.io.*;
import java.util.*;
class BOJ_1464 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String string = br.readLine();
        Deque<Character> dp = new LinkedList<>();
        int idx = 0;
        dp.add(string.charAt(idx));
        boolean flag = true;
        while(++idx < string.length()) {
            char ch = string.charAt(idx);
            if(flag == true) {
                if(Math.abs(Character.compare(dp.peekLast(), ch))-
                    Math.abs(Character.compare(dp.peekFirst(), ch))
                    > 0	&&
                    Character.compare(dp.peekLast(), ch) > 0) {
                    flag = false;
                    dp.addFirst(ch);
                }else {
                    dp.addLast(ch);
                }
            }else {
                if(Math.abs(Character.compare(dp.peekLast(), ch))-
                    Math.abs(Character.compare(dp.peekFirst(), ch)) <0 &&
                    Character.compare(dp.peekFirst(), ch) < 0) {
                    flag = true;
                    dp.addLast(ch);
                }else {
                    dp.addFirst(ch);
                }
            }
        }


        while(!dp.isEmpty()) {
            sb.append(dp.pollFirst());
        }

        System.out.println(sb);

    }
}