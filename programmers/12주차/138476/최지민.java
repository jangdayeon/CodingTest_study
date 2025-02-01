import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> tangerineCnt = new HashMap<>();
        
        for(int t : tangerine) {
            tangerineCnt.put(t, tangerineCnt.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> mapKey = new ArrayList<>(tangerineCnt.keySet());
        
        mapKey.sort((t1, t2) -> tangerineCnt.get(t2).compareTo(tangerineCnt.get(t1)));
        
        int total = 0;
        for(int m : mapKey) {
            total += tangerineCnt.get(m);
            answer++;
            
            if(total >= k) break;
        }
        
        return answer;
    }
}