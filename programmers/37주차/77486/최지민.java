import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], referral[i]);
        }
        
        Map<String, Integer> result = new HashMap<>();
        for(String name : enroll) result.put(name, 0);
        
        for(int i = 0; i < seller.length; i++) {
            int cost = 100 * amount[i];
            String p = seller[i];
            
            while(!p.equals("-") && cost > 0) {
                int profits = cost - (cost / 10);
                
                result.put(p, result.get(p) + profits);
                p = map.get(p);
                cost /= 10;
            }
        }
        
        for(int i = 0; i < enroll.length; i++) {
            answer[i] = result.get(enroll[i]);
        }
        
        return answer;
    }
}