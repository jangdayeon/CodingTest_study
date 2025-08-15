import java.util.*;

class Solution {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    
    class Node {
        int x, y, dir, cost;
        
        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    public int solution(int[][] board) {
        int n = board.length;
        
        int[][][] dist = new int[board.length][board[0].length][4];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) Arrays.fill(dist[i][j], Integer.MAX_VALUE);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        
        for(int i = 0; i < 4; i++) {
            dist[0][0][i] = 0;
        }
        
        pq.offer(new Node(0, 0, -1, 0));
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if(cur.x == n - 1 && cur.y == n - 1) return cur.cost;
            
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(board[nx][ny] == 1) continue;
                
                int add = (cur.dir == -1 || cur.dir == i) ? 100 : 600;
                int cost = cur.cost + add;
                if(dist[nx][ny][i] > cost) {
                    dist[nx][ny][i] = cost;
                    pq.offer(new Node(nx, ny, i, cost));
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) {
            answer = Math.min(answer, dist[n - 1][n - 1][i]);
        }
        
        return answer;
    }
}