import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int itemCount = info.length;
        int INF = 999999;
        int[][] dp = new int[itemCount + 1][m]; // dp[i][b] = A의 최소 흔적

        for (int i = 0; i <= itemCount; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int i = 0; i < itemCount; i++) {
            int aTrace = info[i][0];
            int bTrace = info[i][1];

            for (int b = 0; b < m; b++) {
                if (dp[i][b] == INF) continue;

                // Case 1: A가 훔침
                if (dp[i][b] + aTrace < n) {
                    dp[i + 1][b] = Math.min(dp[i + 1][b], dp[i][b] + aTrace);
                }

                // Case 2: B가 훔침
                if (b + bTrace < m) {
                    dp[i + 1][b + bTrace] = Math.min(dp[i + 1][b + bTrace], dp[i][b]);
                }
            }
        }

        int answer = INF;
        for (int b = 0; b < m; b++) {
            answer = Math.min(answer, dp[itemCount][b]);
        }

        return answer == INF ? -1 : answer;
    }
}
