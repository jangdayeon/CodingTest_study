class Solution {
    int[][] arr;
    int x = 0, y = 0, tmp = 0;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        arr = new int[rows][columns];
        int[] answer = new int[queries.length];
        
        int num = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                arr[i][j] = num++;
            }
        }
        
        for(int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            
            x = q[0] - 1;
            y = q[1] - 1;
            
            tmp = arr[x][y];
            
            int r1 = rotateArr(q[3] - q[1], 0);
            
            int r2 = rotateArr(q[2] - q[0], 3);
            
            int r3 = rotateArr(q[3] - q[1], 1);
            
            int r4 = rotateArr(q[2] - q[0], 2);
            
            answer[i] = Math.min(r1, Math.min(r2, Math.min(r3, r4)));
        }
        
        return answer;
    }
    
    private int rotateArr(int end, int rotate) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        
        int next = 0;
        int minNum = 100000;
        for(int j = 0; j < end; j++) {
            x += dx[rotate];
            y += dy[rotate];
            
            minNum = Math.min(minNum, tmp);
            next = arr[x][y];
            arr[x][y] = tmp;
            tmp = next;
        }
        
        return minNum;
    }
}