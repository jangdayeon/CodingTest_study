import java.util.*;

class Solution {
    char[][] sCharArr;
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        sCharArr = new char[storage.length + 2][storage[0].length() + 2];
        
        for(int i = 0; i < sCharArr.length; i++) {
            for(int j = 0; j < sCharArr[0].length; j++) {
                if(i == 0 || i == sCharArr.length - 1 || j == 0 || j == sCharArr[0].length - 1) sCharArr[i][j] = '.';
                else sCharArr[i][j] = storage[i - 1].charAt(j - 1);
            }
        }
        
        for(String r : requests) {
            if(r.length() >= 2) {
                crane(r.charAt(0));
            } else {
                boolean[][] visited = new boolean[sCharArr.length][sCharArr[0].length];
                forkLift(0, 0, r.charAt(0), visited);
            }
        }
        
        for(char[] charArr : sCharArr) {
            for(char ch : charArr) {
                if(ch != '.') answer++;
            }
        }
        
        return answer;
    }
    
    private void crane(char r) {
        for(int i = 1; i < sCharArr.length - 1; i++) {
            for(int j = 1; j < sCharArr[0].length - 1; j++) {
                if(sCharArr[i][j] == r) {
                    sCharArr[i][j] = '.';
                }
            }
        }
    }
    
    private void forkLift(int x, int y, char target, boolean[][] visited) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            
            x = arr[0];
            y = arr[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= sCharArr.length || ny < 0 || ny >= sCharArr[0].length || visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                
                if(sCharArr[nx][ny] == target) {
                    sCharArr[nx][ny] = '.';
                } else if(sCharArr[nx][ny] == '.') {
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}