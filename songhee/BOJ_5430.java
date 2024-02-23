import java.io.*;
import java.util.*;
class BOJ_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer number;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            String command = br.readLine();

            int n = Integer.parseInt(br.readLine());
            number = new StringTokenizer(br.readLine(), "[,]");
            Deque<Integer> d = new LinkedList<>();
            while(number.hasMoreTokens()) {
                d.add(Integer.parseInt(number.nextToken()));
            }
            boolean flag = true;
            boolean hasEmpty = false;
            for(int i=0;i<command.length();i++) {
                char c = command.charAt(i);
                if(c == 'R') {
                    flag = !flag;
                }else {
                    if(d.isEmpty()) {
                        sb.append("error"+"\n");
                        hasEmpty = true;
                        break;
                    }else {
                        if(flag) {
                            d.poll();
                        }else {
                            d.pollLast();
                        }
                    }
                }
            }

            if(hasEmpty) {
                continue;
            }else if(d.isEmpty()) {
                sb.append("[]\n");
                continue;
            }
            if(flag) {
                sb.append("[");
                while(d.size() > 1) {
                    sb.append(d.pollFirst()+",");
                }
                sb.append(d.pollFirst()+"]");
            }else {
                sb.append("[");
                while(d.size() > 1) {
                    sb.append(d.pollLast()+",");
                }
                sb.append(d.pollLast()+"]");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}