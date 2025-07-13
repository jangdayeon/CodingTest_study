//답 확인함
import java.util.*;

class Solution {
    private int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    private int[] dy = {0, 1, 0, -1};
    
    private boolean[][][] visited;
    private int n, m;
    
    public int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();
        n = grid.length;
        m = grid[0].length();
        visited = new boolean[n][m][4];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<4; k++){
                    if(!visited[i][j][k]){
                        int cnt = move(grid, i, j, k);
                        answer.add(cnt);
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    private int move(String[] grid, int i, int j, int k){
        int cnt = 0;
        
        while(!visited[i][j][k]){ //상우하좌
            visited[i][j][k] = true;
            cnt++;

            char c = grid[i].charAt(j);
            if(c == 'L'){
                k = (k+3) % 4; //시계방향으로 270도 회전
            } else if(c== 'R'){
                k = (k+1) % 4; //시계방향으로 90도 회전
            }
            //냅두면 그냥 직진임
            
            i = (i+dx[k]+n) % n; //격자 넘어가는 거 해결
            j = (j+dy[k]+m) % m;
        }
        
        return cnt;
    }
}