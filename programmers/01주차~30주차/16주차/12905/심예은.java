class Solution {
    public int solution(int[][] board) {
        int n = board.length;    // 행 개수
        int m = board[0].length; // 열 개수
        int maxLen = 0;

        // DP 배열 생성
        int[][] dp = new int[n][m];

        // 첫 번째 행과 첫 번째 열 초기화하고, 1이면 그대로 저장
        for (int i = 0; i < n; i++) {
            dp[i][0] = board[i][0];
            maxLen = Math.max(maxLen, dp[i][0]); // 최대 길이 갱신
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = board[0][j];
            maxLen = Math.max(maxLen, dp[0][j]); // 최대 길이 갱신
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j],
                            Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]); // 최대 길이 갱신
                }
            }
        }

        // 가장 큰 정사각형의 넓이
        return maxLen * maxLen;
    }
}