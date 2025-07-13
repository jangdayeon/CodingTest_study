import java.util.*;

class Solution {
    public int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();

        boolean[][][] visited = new boolean[grid.length][grid[0].length()][4]; // 동,서,남,북
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length(); j++) {
                for(int k = 0; k < 4; k++) {
                    if(!visited[i][j][k]) {
                        answer.add(move(i, j, k, grid, visited));
                    }
                }
            }
        }
        
        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    
    private int move(int x, int y, int d, String[] grid, boolean[][][] visited) {
        int result = 0;
        int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        
        while(!visited[x][y][d]) {
            visited[x][y][d] = true;
            result++;
            
            char node = grid[x].charAt(y);
            if(node == 'L') {
                d = (d + 3) % 4;
            } else if(node == 'R') {
                d = (d + 1) % 4;
            }
            
            x = (x + dir[d][0] + grid.length) % grid.length;
            y = (y + dir[d][1] + grid[0].length()) % grid[0].length();
        }
        
        return result;
    }
}