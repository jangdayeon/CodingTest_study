class Solution {
    private int[] chess;
    private int answer = 0;
    
    public int solution(int n) {
        this.chess = new int[n];
        checkChess(0, n);
        
        return answer;
    }
    
    private void checkChess(int depth, int n) {
        if(depth == n) {
            answer++;
            return;
        }
        
        for(int i = 0; i < n; i++) {
            chess[depth] = i;
            
            if(valid(depth)) {
                checkChess(depth + 1, n);
            }
        }
    }
    
    private boolean valid(int depth) {
        for(int i = 0; i < depth; i++) {
            if(chess[depth] == chess[i]) return false;
            else if(Math.abs(depth - i) == Math.abs(chess[depth] - chess[i])) return false;
        }
        return true;
    }
}