import java.util.*;

class Color {
    int x, y;
    
    public Color(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    boolean[][] visited;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && !visited[i][j]) {
                    answer[0]++;
                    answer[1] = Math.max(colorCnt(i, j, picture, picture[i][j]), answer[1]);
                }
            }
        }
        
        return answer;
    }
    
    private int colorCnt(int x, int y, int[][] picture, int num) {
        Queue<Color> q = new LinkedList();
        q.offer(new Color(x, y));
        
        visited[x][y] = true;
        int cnt = 1;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while(!q.isEmpty()) {
            Color c = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                
                if(nx < picture.length && nx >= 0 && ny < picture[0].length && ny >= 0 && !visited[nx][ny] && picture[nx][ny] == num) {
                    q.offer(new Color(nx, ny));
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}