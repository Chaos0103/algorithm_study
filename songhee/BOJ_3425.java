import java.io.*;
import java.util.*;
public class BOJ_3425 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            List<String> list = new ArrayList<>();

            String order = "";
            while(!(order = br.readLine()).equals("END")) {
                if(order.equals("QUIT")) {
                    System.out.println(sb);
                    return;
                }
                list.add(order);
            }

            int N = Integer.parseInt(br.readLine());
            int sum = 0;
            while(N-->0) {
                long num = Integer.parseInt(br.readLine());
                //프로그램 작동
                String s = calcul(num, list);
                if(s.equals("ERROR")) {
                    sb.append("ERROR"+"\n");
                }else {
                    sb.append(s+"\n");
                }
            }

            sb.append("\n");

            br.readLine();
        }
    }
    private static String calcul(long num, List<String> list) {
        Stack<Long> stack = new Stack<>();
        stack.push(num);
        //list에 쌓인 프로그램을 순차적으로 실행
        for(String program : list) {
            if(program.equals("POP")) {
                //에러여부 판단
                if(!hasElement(stack)) {
                    return "ERROR";
                }
                stack.pop();
            }else if(program.equals("INV")) {
                if(!hasElement(stack)) {
                    return "ERROR";
                }
                Long popNum = stack.pop();
                stack.push(popNum*(-1));
            }else if(program.equals("DUP")) {
                if(!hasElement(stack)) {
                    return "ERROR";
                }
                stack.push(stack.peek());
            }else if(program.equals("SWP")) {
                if(!hasTwoError(stack)) {
                    return "ERROR";
                }
                Long a = stack.pop();//첫번째 수
                Long b = stack.pop();//두번째 수

                stack.push(a); stack.push(b);
            }else if(program.equals("ADD")) {
                if(!hasTwoError(stack)) {
                    return "ERROR";
                }
                Long a = stack.pop();//첫번째 수
                Long b = stack.pop();//두번째 수

                long sum = a+b;

                if(isUptoMax(sum)) {
                    return "ERROR";
                }

                stack.push(a+b);
            }else if(program.equals("SUB")) {
                if(!hasTwoError(stack)) {
                    return "ERROR";
                }
                Long a = stack.pop();//첫번째 수
                Long b = stack.pop();//두번째 수

                long sum = b-a;

                if(isUptoMax(sum)) {
                    return "ERROR";
                }
                //두번째 수 - 첫번째 수
                stack.push(b-a);
            }else if(program.equals("MUL")) {
                if(!hasTwoError(stack)) {
                    return "ERROR";
                }
                Long a = stack.pop();//첫번째 수
                Long b = stack.pop();//두번째 수

                long sum = a*b;

                if(isUptoMax(sum)) {
                    return "ERROR";
                }
                //두번째 수 * 첫번째 수
                stack.push(b*a);
            }else if(program.equals("DIV")) {
                if(!hasTwoError(stack)) {
                    return "ERROR";
                }
                Long a = stack.pop();//첫번째 수
                Long b = stack.pop();//두번째 수

                if(isZero(a)) {
                    return "ERROR";
                }

                Long vd = 0L;
                if(a>0 && b<=0) {
                    b = Math.abs(b);
                    vd = (b/a) * (-1);
                }else if(a<0 && b>=0) {
                    a = Math.abs(a);
                    vd = (b/a) * (-1);
                }else {
                    a = Math.abs(a);
                    b = Math.abs(b);
                    vd = b/a;
                }
                stack.push(vd);
            }else if(program.equals("MOD")) {
                if(!hasTwoError(stack)) {
                    return "ERROR";
                }
                Long a = stack.pop();//첫번째 수
                Long b = stack.pop();//두번째 수

                if(isZero(a)) {
                    return "ERROR";
                }

                Long vd = 0L;
                if(b<0) {
                    a = Math.abs(a);
                    b = Math.abs(b);
                    vd = (b%a)*(-1);
                }else {
                    a = Math.abs(a);
                    b = Math.abs(b);
                    vd = b%a;
                }

                stack.push(vd);
            }else {
                String []arr = program.split(" ");
                int a = Integer.parseInt(arr[1]);

                stack.push((long)a);
            }
        }

        if(hasOneElement(stack)) {
            return String.valueOf(stack.pop());
        }else {
            return "ERROR";
        }
    }
    private static boolean hasOneElement(Stack<Long> stack) {
        if(stack.size() == 1) return true;
        return false;
    }
    private static boolean isZero(Long a) {
        if(a == 0) return true;
        return false;
    }
    private static boolean isUptoMax(long i) {
        long a = Math.abs(i);
        if(a>1000000000) return true;
        return false;
    }
    private static boolean hasTwoError(Stack<Long> stack) {
        if(stack.size() < 2) return false;
        return true;
    }
    private static boolean hasElement(Stack<Long> stack) {
        if(stack.isEmpty()) return false;
        return true;
    }

}
