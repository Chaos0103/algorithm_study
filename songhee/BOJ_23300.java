import java.io.*;
import java.util.*;
class BOJ_23300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        Deque<Integer> back = new LinkedList<>();
        int now = 0;
        Deque<Integer> front = new LinkedList<>();

        while(Q-- >0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("B")) {
                if(back.isEmpty()) continue;
                else {
                    if(now != 0) {
                        front.addFirst(now);
                    }
                    int num = back.pollFirst();
                    now = num;
                }
            }else if(command.equals("F")) {
                if(front.isEmpty()) {
                    continue;
                }else {
                    if(now != 0) {
                        back.addFirst(now);
                    }
                    int num = front.pollFirst();
                    now = num;
                }
            }else if(command.equals("A")) {
                int n = Integer.parseInt(st.nextToken());
                if(!front.isEmpty()) {
                    front.clear();
                }

                if(now != 0) {
                    back.addFirst(now);
                    now = n;
                }else {
                    now = n;
                }

            }else {
                int pollNum = 0;
                Deque<Integer> newD = new LinkedList<>();
                while(!back.isEmpty()) {
                    pollNum = back.pollFirst();
                    newD.add(pollNum);
                    while(!back.isEmpty()) {
                        if(back.peekFirst() == pollNum) {
                            back.pollFirst();
                        }else {
                            break;
                        }
                    }
                }
                back = newD;
            }

            System.out.println(back.peekFirst());
        }

        sb.append(now+"\n");
        if(back.isEmpty()) {
            sb.append(-1+"\n");
        }else {
            while(!back.isEmpty()) {
                sb.append(back.pollFirst()+" ");
            }
            sb.append("\n");
        }

        if(front.isEmpty()) {
            sb.append(-1+"\n");
        }else {
            while(!front.isEmpty()) {
                sb.append(front.pollFirst()+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}