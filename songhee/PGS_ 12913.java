class PGS_12913 {
    int solution(int[][] land) {
        int answer = 0;

        int dp[][] = new int[land.length][land[0].length];

        for(int i=0;i<land[0].length;i++){
            dp[0][i] = land[0][i];
        }

        for(int i=1;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                for(int k=0;k<land[0].length;k++){
                    if(j != k){
                        dp[i][j] = Math.max(dp[i][j], land[i][j]+dp[i-1][k]);
                    }
                }
            }
        }

        for(int i=0;i<land[0].length;i++){
            answer = Math.max(answer, dp[land.length-1][i]);
        }

        return answer;
    }
}