class Solution {
    static final int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][] R = new int[m][n]; // (i,j)에 '오른쪽에서 들어온' 경우의 수
        int[][] D = new int[m][n]; // (i,j)에 '위에서 들어온' 경우의 수

        // 시작칸이 막히면 경로 0
        if (cityMap[0][0] == 1) return 0;

        // 시작에서 한 칸 이동만 시드
        if (n > 1 && cityMap[0][1] != 1) R[0][1] = 1; // (0,0)->(0,1) 오른쪽
        if (m > 1 && cityMap[1][0] != 1) D[1][0] = 1; // (0,0)->(1,0) 아래

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cityMap[i][j] == 1) { // 막힌 칸은 스킵
                    R[i][j] = D[i][j] = 0;
                    continue;
                }
                // 왼쪽에서 (i,j-1) -> (i,j)로 오는 전이: 왼쪽칸의 값으로 턴 가능 여부 판정
                if (j > 0 && cityMap[i][j-1] != 1) {
                    if (cityMap[i][j-1] == 2) {        // 왼쪽칸이 '직진만' -> 오른쪽으로만 직진
                        R[i][j] = (R[i][j] + R[i][j-1]) % MOD;
                    } else {                            // 왼쪽칸이 '자유' -> 직진/턴 모두 가능
                        R[i][j] = (R[i][j] + R[i][j-1] + D[i][j-1]) % MOD;
                    }
                }
                // 위에서 (i-1,j) -> (i,j)로 오는 전이: 위칸의 값으로 턴 가능 여부 판정
                if (i > 0 && cityMap[i-1][j] != 1) {
                    if (cityMap[i-1][j] == 2) {        // 위칸이 '직진만' -> 아래로만 직진
                        D[i][j] = (D[i][j] + D[i-1][j]) % MOD;
                    } else {                            // 위칸이 '자유' -> 직진/턴 모두 가능
                        D[i][j] = (D[i][j] + R[i-1][j] + D[i-1][j]) % MOD;
                    }
                }
            }
        }
        return (R[m-1][n-1] + D[m-1][n-1]) % MOD;
    }
}