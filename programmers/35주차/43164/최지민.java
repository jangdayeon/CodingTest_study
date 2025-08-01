import java.util.*;

class Solution {
    List<String> answer = new ArrayList<>();
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    
    public String[] solution(String[][] tickets) {
        for(String[] t : tickets) {
            map.computeIfAbsent(t[0], k -> new PriorityQueue<>()).add(t[1]);
        }
        
        dfs("ICN");
                
        return answer.toArray(new String[0]);
    }
    
    private void dfs(String start) {
        while(map.containsKey(start) && !map.get(start).isEmpty()) {
            String next = map.get(start).poll();
            dfs(next);
        }
        
        answer.add(0, start);
    }
}