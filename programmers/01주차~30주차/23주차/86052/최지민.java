import java.util.*;

class Solution {
    public int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();
        
        // 4 -> 동, 서, 남, 북
        boolean[][][] visited = new boolean[grid.length][grid[0].length()][4];
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length(); j++) {
                for(int k = 0; k < 4; k++) {
                    if(!visited[i][j][k]) {
                        answer.add(move(i, j, k, visited, grid));
                    }
                }
            }
        }
        
        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    
    private int move(int x, int y, int d, boolean[][][] visited, String[] grid) {
        int result = 0;
        
        // 0: 동, 1: 서, 2: 남, 3: 북
        int[] turnL = {3, 2, 0, 1};
        int[] turnR = {2, 3, 1, 0};
        
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(!visited[x][y][d]) {
            visited[x][y][d] = true;
            result++;
            
            char cell = grid[x].charAt(y);
            
            if(cell == 'L') {
                d = turnL[d];
            } else if(cell == 'R') {
                d = turnR[d];
            }
            
            // 음수일 경우 고려해 길이만큼 +
            x = (x + direction[d][0] + grid.length) % grid.length;
            y = (y + direction[d][1] + grid[0].length()) % grid[0].length();
        }
        
        return result;
    }
}