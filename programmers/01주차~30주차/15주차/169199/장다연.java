//bfs로 해결
import java.util.*;
class Solution {
    //상하좌우 확인을 위한 dx, dy
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};
    
    private final char ROBOT = 'R', DISABLE = 'D', GOAL = 'G';
    
    private int n,m;
    
    //현재 위치 및 깊이를 저장할 Moving 클래스
    private class Moving {
        int x, y, depth;
        
        public Moving(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    
    public int solution(String[] board) {
        int answer = 0;
        
        n = board.length;
        m = board[0].length();
        
        //robot과 goal의 위치 저장
        Moving robot = null;
        Moving goal = null;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                char ch = board[i].charAt(j);
                
                if(ch == ROBOT) {
                    robot = new Moving(i, j, 0);
                } else if (ch == GOAL) {
                    goal = new Moving(i, j, 0);
                }
            }
        }
        
        //bfs 실행
        answer = bfs(board, robot, goal);
        return answer;
    }
    
    private int bfs(String[] board, Moving robot, Moving goal){
        Queue<Moving> qu = new LinkedList<>();
        qu.add(robot);//첫 시작위치 저장
        boolean[][] visited = new boolean[n][m]; //방문이력 저장
        visited[robot.x][robot.y] = true;
        
        while(!qu.isEmpty()){
            Moving cn = qu.poll();
            
            if(cn.x == goal.x && cn.y == goal.y){ //현재 위치가 goal과 같으면 종료
                return cn.depth;
            }
            
            for(int i=0; i<4; i++){ //상하좌우
                int nx = cn.x;
                int ny = cn.y;
                
                while(inRange(nx, ny) && board[nx].charAt(ny) != DISABLE){ //이동 가능할 때까지 이동
                    nx += dx[i];
                    ny += dy[i];
                }
                
                //범위 넘어서거나 장애물 만나기 직전
                nx -= dx[i];
                ny -= dy[i];
                
                //방문 했거나 같은 위치면 스킵
                if(visited[nx][ny] || (cn.x == nx && cn.y == ny)) continue;
                
                visited[nx][ny] = true;
                qu.add(new Moving(nx, ny, cn.depth+1));
            }
        }
        
        return -1;
    }
    
    private boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<m;
    }
}