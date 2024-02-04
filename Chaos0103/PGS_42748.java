import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int size = commands[i][1] - commands[i][0] + 1;
            int[] sub = new int[size];
            System.arraycopy(array, commands[i][0] - 1, sub, 0, size);
            Arrays.sort(sub);
            answer[i] = sub[commands[i][2] - 1];
        }
        return answer;
    }
}
