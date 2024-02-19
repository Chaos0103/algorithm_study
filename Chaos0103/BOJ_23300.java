import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static Stack<Integer> back;
    private static Stack<Integer> front;
    private static int currentPage;

    private static void backward() {
        if (back.isEmpty()) {
            return;
        }
        front.add(currentPage);
        currentPage = back.pop();
    }

    private static void frontward() {
        if (front.isEmpty()) {
            return;
        }
        back.add(currentPage);
        currentPage = front.pop();
    }

    private static void access(int page) {
        front = new Stack<>();
        if (currentPage > 0) {
            back.add(currentPage);
        }
        currentPage = page;
    }

    private static void compress() {
        Stack<Integer> compress = new Stack<>();
        while (!back.isEmpty()) {
            int page = back.pop();
            if (!compress.isEmpty() && compress.peek() == page) {
                continue;
            }
            compress.add(page);
        }

        back = new Stack<>();
        while (!compress.isEmpty()) {
            back.add(compress.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        back = new Stack<>();
        front = new Stack<>();
        currentPage = -1;

        while (q-- > 0) {
            input = br.readLine();
            st = new StringTokenizer(input);
            String cmd = st.nextToken();

            switch (cmd) {
                case "B":
                    backward();
                    break;
                case "F":
                    frontward();
                    break;
                case "A":
                    int page = Integer.parseInt(st.nextToken());
                    access(page);
                    break;
                case "C":
                    compress();
                    break;
            }
        }

        System.out.println(currentPage);

        if (back.isEmpty()) {
            System.out.print(-1);
        } else {
            while (!back.isEmpty()) {
                System.out.print(back.pop() + " ");
            }
        }
        System.out.println();
        if (front.isEmpty()) {
            System.out.println(-1);
        } else {
            while (!front.isEmpty()) {
                System.out.print(front.pop() + " ");
            }
        }
    }
}
