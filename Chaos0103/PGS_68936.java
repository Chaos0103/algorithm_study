class Solution {

    private static int zeroCount = 0;
    private static int oneCount = 0;

    public int[] solution(int[][] arr) {
        tree(arr, 0, 0, arr.length);
        return new int[]{zeroCount, oneCount};
    }

    private int tree(int[][] arr, int x, int y, int size) {
        if (size == 1) {
            if (arr[y][x] == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
            return arr[y][x];
        }

        int a = tree(arr, x, y, size / 2);
        int b = tree(arr, x + size / 2, y, size / 2);
        int c = tree(arr, x, y + size / 2, size / 2);
        int d = tree(arr, x + size / 2, y + size / 2, size / 2);

        if (a == 0 && b == 0 && c == 0 && d == 0) {
            zeroCount -= 3;
            return 0;
        } else if (a == 1 && b == 1 && c == 1 && d == 1) {
            oneCount -= 3;
            return 1;
        }

        return -1;
    }
}
