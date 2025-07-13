class Solution {
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        quad(arr, 0, 0, arr.length);
        return answer;
    }
    
    public void quad(int[][] arr, int x, int y, int n) {
        if(zip(arr, x, y, n, arr[x][y])) {
            answer[arr[x][y] == 1 ? 1 : 0]++;
            return;
        }

        n /= 2;
        quad(arr, x, y, n);
        quad(arr, x, y + n, n);
        quad(arr, x + n, y, n);
        quad(arr, x + n, y + n, n);
    }
    
    public boolean zip(int[][] arr, int x, int y, int n, int v) {
        for(int i = x; i < x + n; i++) {
            for(int j = y; j < y + n; j++) {
                if(arr[i][j] != v) return false;
            }
        }
        return true;
    }
}