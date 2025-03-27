import java.util.*;

class Node {
    private int x, y;
    
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
    public int bfs(int[][] graph, boolean[][] visited, Set<Integer> oilSet, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int landCnt = 1;
        visited[x][y] = true;
        oilSet.add(y);
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= graph.length || ny < 0 || ny >= graph[0].length) continue;
                if(graph[nx][ny] == 0) continue;
                
                if(graph[nx][ny] == 1 && !visited[nx][ny]) {
                    q.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                    landCnt++;
                    
                    oilSet.add(ny);
                }
            }
        }
        
        return landCnt;
    }
    
    public int solution(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        int[] oilCnt = new int[land[0].length];
        
        for(int i = 0; i < land[0].length; i++) {
            for(int j = 0; j < land.length; j++) {
                if(land[j][i] == 1 && !visited[j][i]) {
                    Set<Integer> oilSet = new HashSet<>();
                    int cnt = bfs(land, visited, oilSet, j, i);
                    
                    for(Integer o : oilSet) {
                        oilCnt[o] += cnt;
                    }
                }
            }
        }
        
        return Arrays.stream(oilCnt).max().getAsInt();
    }
}