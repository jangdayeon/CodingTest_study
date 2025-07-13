class Solution {
    private boolean[][] board;
    private int rst = 0;
    public int solution(int n) {
        board = new boolean[n][n];
        for(int i=0; i<n; i++){ //0행에 퀸 넣기
            board[0][i] = true;
            putTheQueen(1, n);
            board[0][i] = false;
        }
        return rst;
    }
    private void putTheQueen(int r, int dept){
        if(r==dept){
            rst++;
        }
        for(int i=0; i<dept; i++){ //행
            if(canPlace(r, i, dept)) {
                board[r][i] = true;
                putTheQueen(r+1, dept);
                board[r][i] = false;
            }
        }
    }
    private boolean canPlace(int row, int col, int n){
        
        //세로
        for(int i=0; i<row; i++){
            if(board[i][col]) return false;
        }
        
        // ↖ 대각선
        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (board[row - i][col - i]) return false;
        }

        // ↗ 대각선
        for (int i = 1; row - i >= 0 && col + i < n; i++) {
            if (board[row - i][col + i]) return false;
        }
        
        return true;
    }
}