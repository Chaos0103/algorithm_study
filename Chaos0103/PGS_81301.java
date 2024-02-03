class Solution {

    private static final String[] NUMBERS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public int solution(String s) {
        for (int i = 0; i < 10; i++) {
            s = s.replace(NUMBERS[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}
