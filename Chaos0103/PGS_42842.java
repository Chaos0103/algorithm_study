class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown + yellow;
        for (int height = 3; height < 5000; height++) {
            if (total % height > 0) {
                continue;
            }

            int width = total / height;
            int count = (width * 2 + height * 2) - 4;
            if (count == brown) {
                answer = new int[]{width, height};
                break;
            }
        }

        return answer;
    }
}
