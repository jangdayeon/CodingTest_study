class Solution {
    public int solution(String[] board) {
        int oCnt = 0;
        int xCnt = 0;
        
        char[][] newBoard = new char[3][3];
        
        for(int i = 0; i < 3; i++) {
            newBoard[i] = board[i].toCharArray();
        }
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(newBoard[i][j] == 'O') oCnt++;
                if(newBoard[i][j] == 'X') xCnt++;
            }
        }
        
        boolean oBingo = checkBingo('O', newBoard);
        boolean xBingo = checkBingo('X', newBoard);
        
        if(oBingo && xBingo) return 0;
        
        if((oCnt == xCnt) && (!oBingo && !xBingo)) return 1;
        if((oCnt == (xCnt + 1)) && (oBingo && !xBingo)) return 1;
        if((oCnt == xCnt) && (!oBingo && xBingo)) return 1;
        if((oCnt == (xCnt + 1)) && (!oBingo && !xBingo)) return 1;
        
        return 0;
    }
    
    private boolean checkBingo(char ox, char[][] newB) {
        for(int i = 0; i < 3; i++) {
            if(newB[i][0] == ox && newB[i][1] == ox && newB[i][2] == ox) return true;
            if(newB[0][i] == ox && newB[1][i] == ox && newB[2][i] == ox) return true;
        }
        
        if(newB[0][0] == ox && newB[1][1] == ox && newB[2][2] == ox) return true;
        if(newB[0][2] == ox && newB[1][1] == ox && newB[2][0] == ox) return true;
        
        return false;
    }
}