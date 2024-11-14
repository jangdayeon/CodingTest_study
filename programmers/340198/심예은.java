import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {

        int N = park.length;        // 공원의 세로 크기 (행)
        int M = park[0].length;     // 공원의 가로 크기 (열)

        // 돗자리 크기 내림차순으로 정렬
        Arrays.sort(mats);
        for (int i = 0; i < mats.length / 2; i++) {
            int temp = mats[i];
            mats[i] = mats[mats.length - 1 - i];
            mats[mats.length - 1 - i] = temp;
        }

        // DP 배열을 사용하여 각 지점에서 깔 수 있는 최대 크기 정사각형을 구한다.
        int[][] dp = new int[N][M];

        // DP 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 만약 해당 자리가 빈 공간("-1")이라면
                if (park[i][j].equals("-1")) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;  // 첫 번째 행 또는 첫 번째 열의 경우 1 크기부터 시작
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;  // 대각선, 상, 좌 3곳에서 최소값 + 1
                    }
                }
            }
        }

        // 가장 큰 정사각형 크기 찾기
        int maxSquareSize = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxSquareSize = Math.max(maxSquareSize, dp[i][j]);
            }
        }

        // 가장 큰 정사각형이 최대 몇 크기인지 확인하고, mats 배열에서 가장 큰 돗자리 크기를 찾아 리턴
        for (int i = 0; i < mats.length; i++) {
            if (mats[i] <= maxSquareSize) {
                return mats[i];  // i
            }
        }

        // 돗자리를 깔 수 없는 경우
        return -1;
    }
}