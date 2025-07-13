import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] board = new int[rows][columns];
        
        int tmp = 1;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] = tmp++;
            }
        }
        
        for(int i=0; i<queries.length; i++){
            //x1행 y1열부터 x2행 y2열까지(based-0);
            int x1 = queries[i][0]-1; 
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            
            int min = Integer.MAX_VALUE;
            
            int before = board[x1][y1];
            
            //위
            for(int j = y1+1; j<=y2; j++){
                int temp = board[x1][j];
                board[x1][j] = before;
                min = Math.min(min, board[x1][j]);
                before = temp;
            }
            
            //오
            for(int j = x1+1; j<=x2; j++){
                int temp = board[j][y2];
                board[j][y2] = before;
                min = Math.min(min, board[j][y2]);
                before = temp;
            }
            
            //하
            for(int j = y2-1; j>=y1; j--){
                int temp = board[x2][j];
                board[x2][j] = before;
                min = Math.min(min, board[x2][j]);
                before = temp;
            }
            
            //왼
            for(int j = x2-1; j>=x1; j--){
                int temp = board[j][y1];
                board[j][y1] = before;
                min = Math.min(min, board[j][y1]);
                before = temp;
            }
            
            
            // print(board);
            answer[i] = min;
        }
        
        return answer;
    }
    public void print(int[][] board){
        for(int i=0; i<board.length; i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
}