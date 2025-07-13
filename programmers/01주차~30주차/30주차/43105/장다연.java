import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = Arrays.copyOf(triangle, triangle.length);
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                if(j==0) dp[i][j] = dp[i-1][j] + triangle[i][j];
                else if(j==dp[i].length-1) dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
            }
        }
        int answer = 0;
        for(int i=0; i<dp[triangle.length-1].length; i++){
            answer = Math.max(answer, dp[triangle.length-1][i]);
        }
        return answer;
    }
}