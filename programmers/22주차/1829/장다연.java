//bfs
import java.util.*;

class Solution {
    private boolean[][] visited;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j] == 0) visited[i][j] = true;
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                    int size = 1;
                    numberOfArea++;
                    while(!q.isEmpty()){
                        int[] now = q.remove();
                        for(int[] spot : whereCanICheck(now, picture)){
                            if(picture[spot[0]][spot[1]] == picture[now[0]][now[1]] && !visited[spot[0]][spot[1]]){
                                q.add(spot);
                                visited[spot[0]][spot[1]] = true;
                                size++;
                            }
                        }
                        
                    }
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }
        
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    private List<int[]> whereCanICheck(int[] now, int[][] picture){
        List<int[]> answer = new ArrayList<>();
        //상 하 좌 우
        int[] x = new int[]{-1, 1, 0, 0};
        int[] y = new int[]{0, 0, -1, 1};
        
        for(int i=0; i<4; i++){
            if(now[0]+x[i] < picture.length && now[0]+x[i] >= 0) {
                if(now[1]+y[i] < picture[0].length && now[1]+y[i] >= 0){
                    answer.add(new int[]{now[0]+x[i], now[1]+y[i]});
                }
            }
        }
        return answer;
    }
}