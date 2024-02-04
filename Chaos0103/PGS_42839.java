import java.util.HashSet;
import java.util.Set;

class Solution {

    private Set<Integer> dfs(char[] arr, int[] visited, String s) {
        Set<Integer> set = new HashSet<>();
        if (!s.isEmpty()) {
            set.add(Integer.parseInt(s));
        }

        if (s.length() == arr.length) {
            return set;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i] > 0) {
                visited[i]--;
                set.addAll(dfs(arr, visited, s + i));
                visited[i]++;
            }
        }

        return set;
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(String numbers) {
        char[] arr = numbers.toCharArray();
        int[] counts = new int[10];
        for (char c : arr) {
            counts[c - '0']++;
        }
        Set<Integer> result = dfs(arr, counts, "");

        return (int) result.stream()
            .filter(this::isPrime)
            .count();
    }
}
