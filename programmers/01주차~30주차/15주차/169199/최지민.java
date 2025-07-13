import java.util.*;

class Node {
    private int x;
    private int y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}

class Solution {
    
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};
    
    public int solution(String[] board) {
        int answer = 0;
        
        char[][] graph = new char[board.length][board[0].length()];
        
        for(int i = 0; i < board.length; i++) {
            graph[i] = board[i].toCharArray();
        }
        
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[0].length; j++) {
                if(graph[i][j] == 'R') {
                    answer = bfs(i, j, graph);
                    break;
                }
            }
        }
        
        return answer;
    }
    
    public static int bfs(int x, int y, char[][] graph) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        
        // 이동 거리를 저장하기 위한 visited 배열
        int[][] visited = new int[graph.length][graph[0].length];
        for(int[] v : visited) {
            Arrays.fill(v, -1);
        }
        
        visited[x][y] = 0;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            // 만약 목표 지점에 도착하면 바로 이동 횟수 반환
            if(graph[node.getX()][node.getY()] == 'G') return visited[node.getX()][node.getY()];
            
            for(int i = 0; i < 4; i++) {
                int nx = node.getX() + dx[i];
                int ny = node.getY() + dy[i];
                
                // 보드 경계 또는 D를 만날 때까지 이동 
                while(nx >= 0 && nx < graph.length && ny >= 0 && ny < graph[0].length && graph[nx][ny] != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }
                
                nx -= dx[i];
                ny -= dy[i];
                
                // 아직 방문하지 않았다면 이동 거리 갱신 후 큐에 삽입
                if(visited[nx][ny] == -1) {
                    visited[nx][ny] = visited[node.getX()][node.getY()] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        
        return -1;
    }
}