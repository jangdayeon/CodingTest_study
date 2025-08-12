import java.util.*;

class Solution {
    private Map<Integer, Set<Integer>> graph = new HashMap<>();
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        for(int[] r : roads){
            Set<Integer> zeroR = graph.getOrDefault(r[0], new HashSet<>());
            zeroR.add(r[1]);
            graph.put(r[0], zeroR);
            
            Set<Integer> oneR = graph.getOrDefault(r[1], new HashSet<>());
            oneR.add(r[0]);
            graph.put(r[1], oneR);
        }

        int[] visited = new int[n+1];
        Arrays.fill(visited, -1);
        int[] answer = bfs(sources, destination, visited);
        return answer;
    }
    private int[] bfs(int[] s, int e, int[] visited){
        Deque<Integer> q = new ArrayDeque<>();
        q.add(e);
        visited[e] = 0;
        while(!q.isEmpty()){
            int now = q.remove();
            for(int next : graph.getOrDefault(now, new HashSet<>())){
                if(visited[next] == -1){
                    visited[next] = visited[now]+1;
                    q.add(next);
                }
            }
        }
        
        int[] answer = new int[s.length];
        for(int i=0; i<s.length; i++){
            answer[i] = visited[s[i]];
        }
        return answer;
    }
}