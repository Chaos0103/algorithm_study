class Solution {
    private String removeZero(String s) {
        return s.replace("0", "");        
    }
    
    public int[] solution(String s) {
        int count = 0;
        int zeroCount = 0;

        while (!s.equals("1")) {
            String removedZero = removeZero(s);
            zeroCount += s.length() - removedZero.length();

            s = Integer.toString(removedZero.length(), 2);
            count++;
        }

        return new int[]{count, zeroCount};
    }
}
