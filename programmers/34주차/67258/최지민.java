import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[]{1, gems.length + 1};
        
        int typeCnt = new HashSet<>(Arrays.asList(gems)).size();
        
        int minLength = Integer.MAX_VALUE;
        int start = 0, end = 0;
        Map<String, Integer> map = new HashMap<>();
        while(end < gems.length) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            
            while(map.get(gems[start]) >= 2) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }

            if(map.keySet().size() == typeCnt) {
                if(minLength > end - start) {
                    minLength = end - start;
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }
            }
            end++;
        }
        
        
        return answer;
    }
}