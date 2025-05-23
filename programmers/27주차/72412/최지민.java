import java.util.*;

class Solution {
    HashMap<String, List<Integer>> allCondi = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for(int i = 0; i < info.length; i++) {
            String[] condi = info[i].split(" ");
            
            condiCase(new String[]{condi[0], condi[1], condi[2], condi[3]}, 0, "", Integer.parseInt(condi[4]));
        }
        
        for(String key : allCondi.keySet()) {
            Collections.sort(allCondi.get(key));
        }
        
        for(int i = 0; i < query.length; i++) {
            String[] q = query[i].split(" ");
            String stringQ = q[0] + " " + q[2] + " " + q[4] + " " + q[6] + " ";
            
            List<Integer> qList = allCondi.get(stringQ);
            
            if(qList == null) {
                answer[i] = 0;
                continue;
            }
            
            int s = Integer.parseInt(q[7]);
            
            int left = 0, right = qList.size() - 1, mid = 0;
            while(left <= right) {
                mid = (left + right) / 2;
                
                if(qList.get(mid) >= s) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            
            answer[i] = qList.size() - left;
        }
        
        return answer;
    }
    
    private void condiCase(String[] condi, int depth, String result, int score) {
        if(depth == 4) {
            allCondi.computeIfAbsent(result, k -> new ArrayList<Integer>()).add(score);
            return;
        }
        
        condiCase(condi, depth + 1, result + "- ", score);
        condiCase(condi, depth + 1, result + condi[depth] + " ", score);
    }
}