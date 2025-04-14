import java.util.*;

class Node {
    int x;
    int y;
    
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
    int[][] areaResult;
    
    private int bfs(int[][] picture, int x, int y, int target) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        areaResult[x][y] = 1;
        
        int value = 1;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = node.getX() + dx[i];
                int ny = node.getY() + dy[i];

                if(nx >= 0 && nx < picture.length && ny >= 0 && ny < picture[0].length 
                   && picture[nx][ny] == target && areaResult[nx][ny] == 0) {
                    areaResult[nx][ny] = 1;
                    q.offer(new Node(nx, ny));
                    value++;
                }
            }
        }

        return value;
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        areaResult = new int[picture.length][picture[0].length];
        
        for(int i = 0; i < picture.length; i++) {
            for(int j = 0; j < picture[0].length; j++) {
                if(areaResult[i][j] == 0 && picture[i][j] != 0) {
                    int v = bfs(picture, i, j, picture[i][j]);
                    answer[1] = Math.max(answer[1], v);
                    answer[0]++;
                }
            }
        }
        return answer;
    }
}