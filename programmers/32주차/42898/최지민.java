import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] graph = new int[m + 2][n + 2];
        graph[1][1] = 1;
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                // i, j 까지의 최단 경로 개수
                if(isPuddle(i, j, puddles) || (i == 1 && j == 1)) continue;
                
                graph[i][j] = (graph[i - 1][j] + graph[i][j - 1]) % 1_000_000_007;
            }
        }
        
        return graph[m][n];
    }
    
    private boolean isPuddle(int x, int y, int[][] puddles) {
        for(int[] p : puddles) {
            if(p[0] == x && p[1] == y) {
                return true;
            }
        }
        
        return false;
    }
}