class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        if(board.length == 1 || board[0].length == 1) {
            for(int[] boardArr : board) {
                for(int b : boardArr) {
                    if(b == 1) return 1;
                }
            }
            return 0;
        }

        for(int i = 1; i < board.length; i++) {
            for(int j = 1; j < board[0].length; j++) {
                if(board[i][j] == 1) {
                    board[i][j] = Math.min(Math.min(board[i][j - 1], board[i - 1][j - 1]), board[i - 1][j]) + 1;
                    
                    if(answer < board[i][j]) answer = board[i][j];
                }
            }
        }

        return answer * answer;
    }
}