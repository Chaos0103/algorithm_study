class Solution {
    private void dfs(int computer, int[][] computers, boolean[] isVisited) {
        isVisited[computer] = true;
        for (int i = 0; i < computers[computer].length; i++) {
            if (computers[computer][i] == 1 && !isVisited[i]) {
                dfs(i, computers, isVisited);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(i, computers, isVisited);
                answer++;
            }
        }
        return answer;
    }
}
