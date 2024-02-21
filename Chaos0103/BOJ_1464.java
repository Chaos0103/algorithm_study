import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        if (str.length() == 1) {
            System.out.println(str);
            return;
        }

        char[] arr = str.toCharArray();

        Deque<Character> dq = new LinkedList<>();
        dq.offer(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (dq.peekFirst() >= arr[i]) {
                dq.offerFirst(arr[i]);
            } else {
                dq.offerLast(arr[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        dq.forEach(sb::append);
        System.out.println(sb);
    }
}
