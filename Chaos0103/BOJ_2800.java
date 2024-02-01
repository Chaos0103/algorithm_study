import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    private static final ArrayList<ArrayList<Integer>> subSet = new ArrayList<>();

    private static class Pair {
        public final int left;
        public final int right;

        private Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        List<Pair> pairs = getPairs(str);
        int[] arr = IntStream.range(0, pairs.size())
            .toArray();

        subSet(arr, arr.length);
        Set<String> set = new HashSet<>();
        for (ArrayList<Integer> sub : subSet) {
            boolean[] checked = new boolean[str.length()];
            for (Integer index : sub) {
                checked[pairs.get(index).left] = true;
                checked[pairs.get(index).right] = true;
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (checked[i]) {
                    continue;
                }
                builder.append(str.charAt(i));
            }
            set.add(builder.toString());
        }

        set.stream().sorted().forEach(System.out::println);
    }

    private static List<Pair> getPairs(String str) {
        List<Pair> pairs = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else if (str.charAt(i) == ')') {
                pairs.add(new Pair(stack.pop(), i));
            }
        }
        return pairs;
    }

    private static void subSet(int[] arr, int n) {
        for (int i = 1; i < (1 << n); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) {
                    temp.add(arr[j]);
                }
            }
            subSet.add(temp);
        }
    }
}
