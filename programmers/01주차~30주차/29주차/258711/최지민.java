import java.util.*;

class Solution {
    HashMap<Integer, List<Integer>> outdeg = new HashMap<>();
    HashMap<Integer, List<Integer>> indeg = new HashMap<>();
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        int maxNode = -1;
        for(int[] e : edges) {
            outdeg.computeIfAbsent(e[0], k -> new ArrayList<Integer>()).add(e[1]);
            indeg.computeIfAbsent(e[1], k -> new ArrayList<Integer>()).add(e[0]);
            
            maxNode = Math.max(maxNode, Math.max(e[0], e[1]));
        }
        
        for(int out : outdeg.keySet()) {
            if(outdeg.get(out).size() >= 2 && !indeg.containsKey(out)) {
                answer[0] = out;
                break;
            }
        }
        
        for(int o : outdeg.get(answer[0])) {
            int[] cnt = bfs(o, new boolean[maxNode + 1]);
            
            if(cnt[0] == cnt[1]) {
                answer[1]++;
            } else if(cnt[0] == cnt[1] + 1) {
                answer[2]++;
            } else if(cnt[0] + 1 == cnt[1]) {
                answer[3]++;
            }
        }
        
        return answer;
    }
    
    private int[] bfs(int start, boolean[] visited) {
        Deque<Integer> q = new ArrayDeque<>();
        
        q.add(start);
        visited[start] = true;
        
        int nodeCnt = 0, edgeCnt = 0;
        
        while(!q.isEmpty()) {
            int x = q.remove();
            nodeCnt++;
            
            if(!indeg.containsKey(x)) continue;
            
            edgeCnt += indeg.get(x).size();
            
            for(int i = 0; i < indeg.get(x).size(); i++) {
                int y = indeg.get(x).get(i);
                
                if(!visited[y]) {
                    q.add(y);
                    visited[y] = true;
                }
            }
        }
        
        return new int[]{nodeCnt, edgeCnt};
    }
}