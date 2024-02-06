class Solution {
    private boolean isValid(int n, int[] times, long mid) {
        long count = 0;
        for (int time : times) {
            count += mid / time;
        }
        return count >= n;
    }

    private long binarySearch(int n, int[] times) {
        long start = 0;
        long end = 1000000000000000000L;

        while (end > start) {
            long mid = (start + end) / 2;
            if (isValid(n, times, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    public long solution(int n, int[] times) {
        return binarySearch(n, times);
    }
}
