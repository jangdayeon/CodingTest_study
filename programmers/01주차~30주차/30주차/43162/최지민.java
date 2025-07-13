import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        HashMap<Integer, HashSet<Integer>> network = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            network.putIfAbsent(i, new HashSet<>());
            for(int j = 0; j < n; j++) {
                if(computers[i][j] == 1 && i != j) {
                    network.get(i).add(j);
                }
            }
        }
        
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(i, visited, network);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int start, boolean[] visited, HashMap<Integer, HashSet<Integer>> network) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(start);
        visited[start] = true;
        
        while(!deque.isEmpty()) {
            int x = deque.remove();
            
            for(int i : network.getOrDefault(x, new HashSet<>())) {
                if(!visited[i]) {
                    visited[i] = true;
                    deque.offer(i);
                }
            }
        }
    }
}