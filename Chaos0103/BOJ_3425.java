import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//60m
public class Main {

    private static Stack<Long> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            List<String> commands = inputCommands(br);
            if (commands == null) {
                return;
            }

            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                long v = Long.parseLong(br.readLine());
                stack = new Stack<>();
                push(v);
                int result = run(commands);
                if (result == 1) {
                    System.out.println(stack.peek());
                } else {
                    System.out.println("ERROR");
                }
            }
            System.out.println();
        }
    }

    private static int run(List<String> commands) {
        long v1, v2, result;
        for (String command : commands) {
            switch (command) {
                case "POP":
                    if (stack.isEmpty()) {
                        return -1;
                    }
                    pop();
                    break;
                case "INV":
                    if (stack.isEmpty()) {
                        return -1;
                    }
                    inv();
                    break;
                case "DUP":
                    if (stack.isEmpty()) {
                        return -1;
                    }
                    dup();
                    break;
                case "SWP":
                    if (isNotEnough()) {
                        return -1;
                    }
                    swp();
                    break;
                case "ADD":
                    if (isNotEnough()) {
                        return -1;
                    }
                    v1 = pop();
                    v2 = pop();
                    result = v1 + v2;
                    if (isOutOfRange(result)) {
                        return -1;
                    }
                    push(result);
                    break;
                case "SUB":
                    if (isNotEnough()) {
                        return -1;
                    }
                    v1 = pop();
                    v2 = pop();
                    result = v2 - v1;
                    if (isOutOfRange(result)) {
                        return -1;
                    }
                    push(result);
                    break;
                case "MUL":
                    if (isNotEnough()) {
                        return -1;
                    }
                    v1 = pop();
                    v2 = pop();
                    result = v1 * v2;
                    if (isOutOfRange(result)) {
                        return -1;
                    }
                    push(result);
                    break;
                case "DIV":
                    if (isNotEnough()) {
                        return -1;
                    }
                    v1 = pop();
                    v2 = pop();
                    if (isZero(v1)) {
                        return -1;
                    }
                    result = Math.abs(v2) / Math.abs(v1);
                    if (v1 * v2 < 0) {
                        result *= -1;
                    }
                    push(result);
                    break;
                case "MOD":
                    if (isNotEnough()) {
                        return -1;
                    }
                    v1 = pop();
                    v2 = pop();
                    if (isZero(v1)) {
                        return -1;
                    }
                    result = Math.abs(v2) % Math.abs(v1);
                    if (v2 < 0) {
                        result *= -1;
                    }
                    push(result);
                    break;
                default:
                    long v = Long.parseLong(command.split(" ")[1]);
                    push(v);
            }
        }
        return stack.size();
    }

    private static List<String> inputCommands(BufferedReader br) throws IOException {
        List<String> commands = new ArrayList<>();
        while (true) {
            String command = br.readLine();
            if (command.isBlank()) {
                continue;
            }
            if (command.equals("QUIT")) {
                return null;
            }
            if (command.equals("END")) {
                break;
            }
            commands.add(command);
        }
        return commands;
    }

    private static void push(long v) {
        stack.push(v);
    }

    private static long pop() {
        return stack.pop();
    }


    private static void inv() {
        long v = pop();
        push(v * -1);
    }

    private static void dup() {
        long v = stack.peek();
        push(v);
    }

    private static void swp() {
        long v1 = pop();
        long v2 = pop();
        push(v1);
        push(v2);
    }

    private static boolean isOutOfRange(long v) {
        return Math.abs(v) > 1000000000;
    }

    private static boolean isNotEnough() {
        return stack.size() < 2;
    }

    private static boolean isZero(long v) {
        return v == 0;
    }

}
