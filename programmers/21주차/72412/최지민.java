import java.util.*;

class Solution {
    Map<String, List<Integer>> infoMap = new HashMap<>();
    
    private void dfs(String[] condition, String result, int depth, int score) {
        if(depth == 4) {
            List<Integer> scoreList = infoMap.containsKey(result) ? infoMap.get(result) : new ArrayList<>();
            
            scoreList.add(score);
            
            infoMap.put(result, scoreList);
            return;
        }
        
        dfs(condition, result + "-", depth + 1, score);
        dfs(condition, result + condition[depth], depth + 1, score);
    }
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for(int i = 0; i < info.length; i++) {
            String[] condition = info[i].split(" ");
            
            dfs(new String[]{condition[0], condition[1], condition[2], condition[3]}, "", 0, Integer.parseInt(condition[4]));
        }
        
        for(String key : infoMap.keySet()) {
            Collections.sort(infoMap.get(key));
        }
        
        for(int i = 0; i < query.length; i++) {
            String[] q = query[i].split(" ");
            List<Integer> qList = infoMap.get(""+q[0]+q[2]+q[4]+q[6]);
            
            if(qList == null) {
                answer[i] = 0;
                continue;
            }
            
            int score = Integer.parseInt(q[q.length - 1]);
            
            int left = 0, right = qList.size() - 1, mid = (left + right) / 2;
            while(left <= right) {
                mid = (left + right) / 2;
                
                if(qList.get(mid) >= score) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            
            answer[i] = qList.size() - left;
        }
        
        return answer;
    }
}