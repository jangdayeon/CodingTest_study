//[type, r1, c1, r2, c2, degree]
//type 1 = 공격, 2 = 회복
//(r1,c1) -> (r2, c2)
//degree 만큼
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] sum = new int[board.length+1][board[0].length+1];
        for(int[] s : skill){
            boolean isAttack = s[0] == 1 ? true : false;
            int r1 = s[1], c1 = s[2];
            int r2 = s[3], c2 = s[4];
            int degree = isAttack? -s[5] : s[5];
            
            sum[r1][c1] += degree;
            sum[r1][c2+1] += -degree;
            sum[r2+1][c1] += -degree;
            sum[r2+1][c2+1] += degree;
        }
        
        // 세로로 누적합
        for(int col = 0; col < board[0].length+1; col++){
            for(int row = 0; row < board.length; row++){
                sum[row+1][col] += sum[row][col];
            }
        }
        
        // 가로로 누적합
        for(int row = 0; row < board.length+1; row++){
            for(int col = 0; col < board[0].length; col++){
                sum[row][col+1] += sum[row][col];
            }
        }
        
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                board[row][col] += sum[row][col];
                if(board[row][col] > 0) answer++;
            }
        }
        return answer;
    }
}