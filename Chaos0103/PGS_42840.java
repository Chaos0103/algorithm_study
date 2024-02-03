import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final int[][] METHODS = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public int[] solution(int[] answers) {
        int[] counts = new int[3];
        int max = 0;

        for (int i = 0; i < 3; i++) {
            int index = 0;
            int size = METHODS[i].length;
            for (int answer : answers) {
                if (answer == METHODS[i][index++ % size]) {
                    counts[i]++;
                }
            }
            max = Math.max(max, counts[i]);
        }

        List<Integer> peoples = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (counts[i] == max) {
                peoples.add(i + 1);
            }
        }

        return peoples.stream()
            .mapToInt(people -> people)
            .toArray();
    }
}
