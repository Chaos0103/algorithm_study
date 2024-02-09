import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack<Integer>[] stacks = new Stack[4];
        for (int i = 0; i < 4; i++) {
            stacks[i] = new Stack<>();
            stacks[i].push(0);
        }

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < 4; j++) {
                if (stacks[j].peek() < arr[i]) {
                    stacks[j].push(arr[i]);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
