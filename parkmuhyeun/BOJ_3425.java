import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    static long over = 1000000001;
    static StringBuilder res = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String startCheck = br.readLine();
            if (startCheck.equals("")) {
                continue;
            }
            if (startCheck.equals("QUIT")) {
                break;
            }

            List<String> commands = new ArrayList<>();
            commands.add(startCheck);
            while (!startCheck.equals("END")) {
                startCheck = br.readLine();
                commands.add(startCheck);
            }

            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                GoStack goStack = new GoStack();
                goStack.numX(Long.valueOf(br.readLine()));

                if (commands.size() == 1) {
                    String val = Math.abs(goStack.stack.get(0)) >= over ? "ERROR" : goStack.stack.get(0).toString();
                    res.append(val + "\n");
                } else {
                    boolean go = false;
                    for (int j = 0; j < commands.size() - 1; j++) {
                        String command = commands.get(j);
                        go = process(goStack, command);
                        if (!go) {
                            break;
                        }
                    }

                    if (!go || goStack.size() != 1 ) {
                        res.append("ERROR" + "\n");
                    } else {
                        String val = Math.abs(goStack.stack.get(0)) >= over ? "ERROR" : goStack.stack.get(0).toString();
                        res.append(val + "\n");
                    }
                }
            }

            res.append("\n");
        }
        System.out.println(res);
    }

    private static boolean process(GoStack goStack, String command) {
        if (command.equals("POP")) {
            return goStack.pop() < over;
        } else if (command.equals("INV")) {
            return goStack.inv();
        } else if (command.equals("DUP")) {
            return goStack.dup();
        } else if (command.equals("SWP")) {
            return goStack.swp();
        } else if (command.equals("ADD")) {
            return goStack.add();
        } else if (command.equals("SUB")) {
            return goStack.sub();
        } else if (command.equals("MUL")) {
            return goStack.mul();
        } else if (command.equals("DIV")) {
            return goStack.div();
        } else if (command.equals("MOD")) {
            return goStack.mod();
        }
        String[] split = command.split(" ");
        goStack.numX(Integer.parseInt(split[1]));
        return true;
    }

    static class GoStack {
        Stack<Long> stack = new Stack<>();

        public int size() {
            return stack.size();
        }

        public void numX(long v) {
            stack.push(v);
        }

        public long pop() {
            if (stack.isEmpty()) {
                return over;
            }
            return stack.pop();
        }

        public boolean inv() {
            if (stack.isEmpty()) {
                return false;
            }
            long pop = stack.pop();
            stack.push(-1 * pop);
            return true;
        }

        public boolean dup() {
            if (stack.isEmpty()) {
                return false;
            }
            long peek = stack.peek();
            stack.push(peek);
            return true;
        }

        public boolean swp() {
            if (stack.size() < 2) {
                return false;
            }
            long first = stack.pop();
            long second = stack.pop();
            stack.push(first);
            stack.push(second);
            return true;
        }

        public boolean add() {
            if (stack.size() < 2) {
                return false;
            }
            long first = stack.pop();
            long second = stack.pop();
            if (first + second >= over) {
                return false;
            }
            stack.push(first + second);
            return true;
        }

        public boolean sub() {
            if (stack.size() < 2) {
                return false;
            }
            long first = stack.pop();
            long second = stack.pop();
            if (Math.abs(second - first) >= over) {
                return false;
            }
            stack.push(second - first);
            return true;
        }

        public boolean mul() {
            if (stack.size() < 2) {
                return false;
            }
            long first = stack.pop();
            long second = stack.pop();
            long mul = first * second;
            if (mul >= over) {
                return false;
            }
            stack.push(mul);
            return true;
        }

        public boolean div() {
            if (stack.size() < 2) {
                return false;
            }
            boolean plus = true;
            long first = stack.pop();
            if (first == 0) {
                return false;
            }
            long second = stack.pop();
            if (first * second < 0) {
                plus = false;
            }

            long div = Math.abs(second) / Math.abs(first);
            if (div >= over) {
                return false;
            }
            if (plus) {
                stack.push(div);
            } else {
                stack.push(-1 * div);
            }
            return true;
        }

        public boolean mod() {
            if (stack.size() < 2) {
                return false;
            }
            long first = stack.pop();
            if (first == 0) {
                return false;
            }
            long second = stack.pop();
            long mod = Math.abs(second) % Math.abs(first);
            if (mod >= over) {
                return false;
            }
            if (second < 0) {
                stack.push(-1 * mod);
            } else {
                stack.push(mod);
            }
            return true;
        }
    }
}
