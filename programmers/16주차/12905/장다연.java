//답 찾아봄.. dp로 풀어야 함
import java.util.*;

class Solution{
    public int solution(int [][]board){
        int answer = Arrays.stream(board[0]).max().getAsInt();
        for(int i=1; i<board.length; i++){
            for(int j=1; j<board[0].length; j++){
                if(board[i][j] == 1){
                    board[i][j] = 1 + Math.min(Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1]);
                }
                answer = Math.max(answer, board[i][j]);
            }
        }
        return answer*answer;
    }
}