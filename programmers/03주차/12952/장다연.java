import java.util.*;

class Solution {
    static boolean[][] board; // 체스판
    static int answer = 0; // 해답의 개수
    
    public int solution(int n) {
        board = new boolean[n][n]; // 체스판 크기 초기화
        recursive(0); // 첫 번째 행부터 탐색 시작
        return answer;
    }

    // 백트래킹 함수: 현재 행을 탐색
    static void recursive(int row) {
        if (row == board.length) { // 모든 퀸을 배치한 경우
            answer++; 
            return;
        }

        
        for (int col = 0; col < board.length; col++) {
            if (isSafe(row, col)) { // 해당 위치가 안전하다면
                board[row][col] = true; // 퀸 배치
                recursive(row + 1); // 다음 행으로 재귀 호출
                board[row][col] = false; // 백트래킹: 상태 복원
            }
        }
    }

    // 해당 위치가 퀸을 놓을 수 있는지 체크하는 함수
    static boolean isSafe(int row, int col) {
        // 위쪽 열 체크
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }

        // 왼쪽 위 대각선 체크
        for (int i = 1; i <= row && col - i >= 0; i++) {
            if (board[row - i][col - i]) return false;
        }

        // 오른쪽 위 대각선 체크
        for (int i = 1; i <= row && col + i < board.length; i++) {
            if (board[row - i][col + i]) return false;
        }

        return true;
    }
}
