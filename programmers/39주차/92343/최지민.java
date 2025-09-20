import java.util.*;

class Solution {
    int answer = 0;
    Map<Integer, List<Integer>> graph = new HashMap<>();
    
    public int solution(int[] info, int[][] edges) {
        for(int i = 0; i < info.length; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        
        List<Integer> candidate = new ArrayList<>();
        candidate.addAll(graph.get(0));
        dfs(candidate, 1, 0, info);
        
        return answer;
    }
    
    private void dfs(List<Integer> candidate, int s, int w, int[] info) {
        answer = Math.max(answer, s);

        for(int i = 0; i < candidate.size(); i++) {
            int next = candidate.get(i);
            
            List<Integer> nextCandidate = new ArrayList<>(candidate);
            System.out.println(nextCandidate);
            
            nextCandidate.remove(i);
            nextCandidate.addAll(graph.get(next));
            
            if(info[next] == 0) {
                dfs(nextCandidate, s + 1, w, info);
            } else {
                if(s > w + 1) {
                    dfs(nextCandidate, s, w + 1, info);
                }
            }
        }
    }
}