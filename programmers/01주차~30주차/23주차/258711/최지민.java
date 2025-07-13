import java.util.*;

class Solution {
    private List<Integer> bfs(Map<Integer, List<Integer>> map, boolean[] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        
        visited[start] = true;
        List<Integer> result = new ArrayList<>();
        result.add(start);
        
        while(!q.isEmpty()) {
            int n = q.poll();
            
            if(map.containsKey(n)) {
                for(int k : map.get(n)) {
                    if(!visited[k]) {
                        q.offer(k);
                        visited[k] = true;
                        result.add(k);
                    }
                }
            }
        }
        return result;
    }
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        Map<Integer, List<Integer>> indeg = new HashMap<>();
        Map<Integer, List<Integer>> outdeg = new HashMap<>();
        
        int maxId = -1;
        for(int[] edge : edges) {
            indeg.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
            outdeg.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            
            maxId = Math.max(maxId, Math.max(edge[0], edge[1]));
        }
        
        for(int key : outdeg.keySet()) {
            if(outdeg.get(key).size() >= 2) {
                if(!indeg.containsKey(key)) {
                    answer[0] = key;
                    break;
                }
            }
        }
        
        boolean[] visited = new boolean[maxId + 1];
        visited[answer[0]] = true;
        for(int n : outdeg.get(answer[0])) {
            if(visited[n]) continue;
            List<Integer> result = bfs(outdeg, visited, n);
            
            int edgeSum = 0;
            for(int r : result) {
                edgeSum += (outdeg.containsKey(r) ? outdeg.get(r).size() : 0);
            }
            
            if(result.size() == edgeSum) answer[1]++;
            else if(result.size() == edgeSum + 1) answer[2]++;
            else if(result.size() + 1 == edgeSum) answer[3]++;
        }
        
        return answer;
    }
}