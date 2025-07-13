import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visited  = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j] != 0 && !visited[i][j]){
                    maxSizeOfOneArea = Math.max(bfs(i, j, picture, visited), maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    private int bfs(int i, int j, int[][] picture, boolean[][] visited){
        //up down left right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int nowColor = picture[i][j];
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            int[] spot = q.remove();
            
            cnt++;
            for(int z=0; z<4; z++){
                int nx = spot[0] + dx[z];
                int ny = spot[1] + dy[z];
                if(nx > -1 && nx < picture.length && ny > -1 && ny < picture[0].length 
                   && picture[nx][ny] == nowColor && !visited[nx][ny]){
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return cnt;
    }
}