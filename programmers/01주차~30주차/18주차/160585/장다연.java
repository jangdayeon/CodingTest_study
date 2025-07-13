//아닌 경우
//선공보다 후공의 수가 더 클 경우
//선공과 후공의 수가 같은데, 선공이 이미 이겼을 경우
import java.util.*;

class Solution {
    public int solution(String[] board) {
        String[][] b = make2dArr(board);
        int[] cnt = cntOX(b);
        boolean oWin = isWinner(b, "O");
        boolean xWin = isWinner(b, "X");
        
        // 기본적인 턴 수 검사
        if(cnt[0] < cnt[1] || cnt[0] - cnt[1] > 1) return 0;
        
        // 둘 다 승리한 경우는 불가능
        if(oWin && xWin) return 0;
        
        // O가 이겼는데 O와 X 개수가 같다면 잘못된 상태
        if(oWin && cnt[0] == cnt[1]) return 0;
        
        // X가 이겼는데 O가 X보다 더 많다면 잘못된 상태
        if(xWin && cnt[0] > cnt[1]) return 0;
        
        return 1;
    }
    
    public int[] cntOX(String[][] b){
        int[] rtn = new int[2];
        for(int i=0; i<b.length; i++){
            for(int j=0; j<b[0].length; j++){
                if(b[i][j].equals("O")) rtn[0]++;
                if(b[i][j].equals("X")) rtn[1]++;
            }
        }
        return rtn;
    }
    
    public String[][] make2dArr(String[] b){
        String[][] rtn = new String[b.length][];
        for(int i=0; i<b.length; i++){
            rtn[i] = b[i].split("");
        }
        return rtn;
    }
    
    public boolean isWinner(String[][] b, String player) {
        // 가로 확인
        for(int i = 0; i < 3; i++) {
            if(b[i][0].equals(player) && b[i][1].equals(player) && b[i][2].equals(player)) 
                return true;
        }
        // 세로 확인
        for(int j = 0; j < 3; j++) {
            if(b[0][j].equals(player) && b[1][j].equals(player) && b[2][j].equals(player)) 
                return true;
        }
        // 대각선 확인
        if(b[0][0].equals(player) && b[1][1].equals(player) && b[2][2].equals(player)) 
            return true;
        if(b[0][2].equals(player) && b[1][1].equals(player) && b[2][0].equals(player)) 
            return true;
        
        return false;
    }
}