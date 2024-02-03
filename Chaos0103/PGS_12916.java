class Solution {
    boolean solution(String s) {
        int count = 0;
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            if (c == 'p') {
                count++;
            } else if (c == 'y') {
                count--;
            }
        }

        return count == 0;
    }
}
