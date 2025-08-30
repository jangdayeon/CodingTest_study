import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        Map<Integer, List<Integer>> winPlayer = new HashMap<>();
        Map<Integer, List<Integer>> losePlayer = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            winPlayer.put(i + 1, new ArrayList<>());
            losePlayer.put(i + 1, new ArrayList<>());
        }
        
        for(int i = 0; i < results.length; i++) {
            winPlayer.get(results[i][0]).add(results[i][1]);
            losePlayer.get(results[i][1]).add(results[i][0]);
        }
        
        for(int i = 0; i < n; i++) {
            int winDepth = rank(i + 1, winPlayer, new boolean[n + 1]);
            int loseDepth = rank(i + 1, losePlayer, new boolean[n + 1]);
            
            if(winDepth + loseDepth == n - 1) answer++;
        }
        
        return answer;
    }
    
    private int rank(int start, Map<Integer, List<Integer>> player, boolean[] visited) {
        visited[start] = true;
        int depth = 0;
        
        for(int p : player.get(start)) {
            if(!visited[p]) depth += 1 + rank(p, player, visited);
        }
        
        return depth;
    }
}