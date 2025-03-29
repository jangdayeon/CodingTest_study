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
    private void bfs(char[][] storage, boolean[][] visited, int x, int y, char target) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        
        if(storage[x][y] == target) storage[x][y] = '.';
        visited[x][y] = true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = node.getX() + dx[i];
                int ny = node.getY() + dy[i];
                
                if(nx >= 0 && nx < storage.length && ny >= 0 && ny < storage[0].length && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    
                    if(storage[nx][ny] == target) {
                        storage[nx][ny] = '.';
                    } else if(storage[nx][ny] == '.') {
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }
    }
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        char[][] map = new char[storage.length + 2][storage[0].length() + 2];
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(i == 0 || i == (map.length - 1) || j == 0 || j == (map[0].length - 1)) map[i][j] = '.';
                else map[i][j] = storage[i - 1].charAt(j - 1);
            }
        }
        
        
        for(String r : requests) {
            char target = r.charAt(0);
            
            if(r.length() >= 2) {
                for(int i = 0; i < map.length; i++) {
                    for(int j = 0; j < map[0].length; j++) {
                        if(map[i][j] == target) map[i][j] = '.';
                    }
                }
            } else {
                boolean[][] visited = new boolean[map.length][map[0].length];
                
                bfs(map, visited, 0, 0, target);
            }
        }
        
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(map[i][j] != '.') answer++;
            }
        }
        
        return answer;
    }
}