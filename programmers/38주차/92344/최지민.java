import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int N = board.length, M = board[0].length;
        
        int[][] ps = new int[N + 1][M + 1];
        for(int[] s : skill) {
            int r1 = s[1], c1 = s[2], r2 = s[3], c2 = s[4];
            int degree = (s[0] == 1) ? -s[5] : s[5];
            
            ps[r1][c1] += degree;
            ps[r1][c2 + 1] -= degree;
            ps[r2 + 1][c1] -= degree;
            ps[r2 + 1][c2 + 1] += degree;
        }
        
        // 누적합
        for(int i = 1; i < M; i++) {
            for(int j = 0; j < M; j++) {
                ps[i][j] += ps[i - 1][j];
            }
        }
        
        for(int i = 1; i < M; i++) {
            for(int j = 0; j < N; j++) {
                ps[j][i] += ps[j][i - 1];
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] + ps[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}