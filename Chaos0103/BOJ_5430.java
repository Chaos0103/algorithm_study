import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            Deque<Integer> d = new ArrayDeque<>();

            String p = sc.nextLine();
            int n = sc.nextInt();
            sc.nextLine();
            String array = sc.nextLine();
            String[] numbers = array
                    .substring(1, array.length() - 1)
                    .split(",");

            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(numbers[j]);
                d.offer(num);
            }

            int reversCount = 0;
            for (char ch : p.toCharArray()) {
                if (ch == 'D') {
                    if (d.isEmpty()) {
                        reversCount = -1;
                        break;
                    }
                    if (reversCount % 2 == 0) {
                        d.pollFirst();
                    } else {
                        d.pollLast();
                    }
                } else {
                    reversCount++;
                }
            }

            if (reversCount == -1) {
                System.out.println("error");
            } else {
                List<Integer> result = new ArrayList<>(d);
                if (reversCount % 2 == 0) {
                    System.out.println(result.toString().replaceAll(", ", ","));
                } else {
                    Collections.reverse(result);
                    System.out.println(result.toString().replaceAll(", ", ","));
                }
            }

        }
    }
}
