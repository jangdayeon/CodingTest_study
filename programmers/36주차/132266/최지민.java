import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < roads.length; i++) {
            graph.computeIfAbsent(roads[i][0], k -> new ArrayList<>()).add(roads[i][1]);
            graph.computeIfAbsent(roads[i][1], k -> new ArrayList<>()).add(roads[i][0]);
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(destination);
        dist[destination] = 0;
        
        while(!deque.isEmpty()) {
            int x = deque.poll();
            for(int y : graph.getOrDefault(x, new ArrayList<>())) {
                if(dist[y] == -1) {
                    dist[y] = dist[x] + 1;
                    deque.offer(y);
                }
            }
        }
        
        for(int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
}