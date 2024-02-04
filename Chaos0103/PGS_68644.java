import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> sum = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sum.add(numbers[i] + numbers[j]);
            }
        }
        return sum.stream().sorted()
            .mapToInt(s -> s)
            .toArray();
    }
}
