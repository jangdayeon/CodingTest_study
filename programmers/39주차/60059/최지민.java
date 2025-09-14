class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int N = lock.length, M = key.length;
        
        int[][] board = new int[N + 2 * (M - 1)][N + 2 * (M - 1)];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                board[i + (M - 1)][j + (M - 1)] = lock[i][j];
            }
        }
        
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < (M - 1) + N; j++) {
                for(int k = 0; k < (M - 1) + N; k++) {
                    add(board, key, j, k);
                    
                    if(check(board, N, M)) return true;
                    
                    sub(board, key, j, k);
                }
                System.out.println();
            }
            key = rotate(key);
        }
        
        return false;
    }
    
    private int[][] rotate(int[][] key) {
        int[][] rotated = new int[key.length][key.length];
        
        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key.length; j++) {
                rotated[j][key.length - 1 - i] = key[i][j];
            }
        }
        
        return rotated;
    }
    
    private void add(int[][] board, int[][] key, int x, int y) {
        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key.length; j++) {
                board[x + i][y + j] += key[i][j];
            }
        }
    }
    
    private boolean check(int[][] board, int N, int M) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i + (M - 1)][j + (M - 1)] != 1) return false;
            }
        }
        
        return true;
    }
    
    private void sub(int[][] board, int[][] key, int x, int y) {
        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key.length; j++) {
                board[x + i][y + j] -= key[i][j];
            }
        }
    }
}