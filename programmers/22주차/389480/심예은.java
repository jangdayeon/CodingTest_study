class Solution {
    int answer = Integer.MAX_VALUE;
    int[][] info;
    int n, m;
    int[][][] dp;

    public int solution(int[][] info, int n, int m) {
        this.info = info;
        this.n = n;
        this.m = m;

        dp = new int[info.length][n][m];
        dfs(0, 0, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    void dfs(int depth, int aSum, int bSum) {
        if (aSum >= n || bSum >= m) return;
        if (depth == info.length) {
            answer = Math.min(answer, aSum);
            return;
        }
        if (dp[depth][aSum][bSum] == 1) return;
        dp[depth][aSum][bSum] = 1;

        dfs(depth + 1, aSum + info[depth][0], bSum);
        dfs(depth + 1, aSum, bSum + info[depth][1]);
    }
}
