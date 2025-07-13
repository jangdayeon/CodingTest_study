import java.util.*;
class Solution {
    private final int MOD = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        //zero-based로 전체 수정
        int[][] dp = new int[n][m];
        for(int[] p : puddles){
            dp[p[1]-1][p[0]-1] = -1;
        }
        
        dp[0][0] = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dp[i][j] == -1) continue;
                //위에서 오기
                if (i > 0 && dp[i - 1][j] != -1) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                }
                // 왼쪽에서 오기
                if (j > 0 && dp[i][j - 1] != -1) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                }
            }
        }
        // for(int i=0; i<n;i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        return dp[n-1][m-1];
    }
}