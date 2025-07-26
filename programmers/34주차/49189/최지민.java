import java.util.*;

class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
        
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        for(int i = 0; i < edge.length; i++) {
            graph.computeIfAbsent(edge[i][0], k -> new ArrayList<>()).add(edge[i][1]);
            graph.computeIfAbsent(edge[i][1], k -> new ArrayList<>()).add(edge[i][0]);
        }
        
        int[] visited = new int[n + 1];
        
        bfs(1, visited);
        
        int maxLength = 0;
        for(int i = 0; i < n + 1; i++) {
            maxLength = Math.max(maxLength, visited[i]);
        }
        
        for(int i = 0; i < n + 1; i++) {
            if(maxLength == visited[i]) answer++;
        }
        return answer;
    }
    
    private void bfs(int start, int[] visited) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(start);
        
        visited[start] = 1;
        
        while(!deque.isEmpty()) {
            int x = deque.poll();
            
            for(int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                
                if(visited[y] == 0) {
                    deque.offer(y);
                    visited[y] = visited[x] + 1;
                }
            }
        }
    }
}