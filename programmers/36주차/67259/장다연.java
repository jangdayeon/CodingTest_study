import java.util.*;

class Solution {
    //상좌하우
    private int[] dx = new int[]{-1,0,1,0};
    private int[] dy = new int[]{0,-1,0,1};
    private int[][][] visited;
    public int solution(int[][] board) {
        visited = new int[4][board.length][board[0].length];
        for (int d = 0; d < 4; d++) {
            for (int i = 0; i < board.length; i++) {
                Arrays.fill(visited[d][i], Integer.MAX_VALUE);
            }
        }
        dijkstra(board);
        
        int answer = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++) {
            answer = Math.min(answer, visited[d][board.length - 1][board[0].length - 1]);
        }
        return answer;
    }
    private void dijkstra(int[][] board){
        Deque<int[]> q = new ArrayDeque<>(); //{방향(0,1,2,3), x위치, y위치}
        visited[2][0][0] = 0;
        visited[3][0][0] = 0;
        q.add(new int[]{2,0,0}); //하
        q.add(new int[]{3,0,0});
        while(!q.isEmpty()){
            int[] now = q.remove();
            int cost = visited[now[0]][now[1]][now[2]];
            for(int i=0; i<4; i++){
                int nextX = now[1] + dx[i];
                int nextY = now[2] + dy[i];
                if(isInBoard(nextX, nextY, board) && board[nextX][nextY] != 1){
                    int nextWeight = cost + (now[0] == i ? 100 : 600);
                    if(visited[i][nextX][nextY] > nextWeight){
                        visited[i][nextX][nextY] = nextWeight;
                        q.add(new int[]{i, nextX, nextY});
                    }
                }
            }
        }
    }
    private boolean isInBoard(int x, int y, int[][] board){
        if(x > -1 && x < board.length && y > -1 && y < board[0].length){
            return true;
        } else {
            return false;
        }
    }
}