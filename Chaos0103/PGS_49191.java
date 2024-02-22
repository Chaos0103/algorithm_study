class Solution {
    private int winsCount(int y, boolean[][] graph, boolean[] isVisited) {
        int count = 1;
        for (int x = 0; x < graph[y].length; x++) {
            if (!graph[y][x] || isVisited[x]) {
                continue;
            }
            isVisited[x] = true;
            count += winsCount(x, graph, isVisited);
        }
        return count;
    }

    private int losesCount(int x, boolean[][] graph, boolean[] isVisited) {
        int count = 1;
        for (int y = 0; y < graph.length; y++) {
            if (!graph[y][x] || isVisited[y]) {
                continue;
            }
            isVisited[y] = true;
            count += losesCount(y, graph, isVisited);
        }
        return count;
    }

    public int solution(int n, int[][] results) {
        boolean[][] graph = new boolean[n][n];
        for (int[] result : results) {
            int y = result[0] - 1;
            int x = result[1] - 1;
            graph[y][x] = true;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            int wins = winsCount(i, graph, new boolean[n]) - 1;
            int loses = losesCount(i, graph, new boolean[n]) - 1;
            if (wins + loses + 1 == n) {
                result++;
            }
        }
        return result;
    }
}
