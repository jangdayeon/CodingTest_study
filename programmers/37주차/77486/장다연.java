import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] result = new int[enroll.length];
        
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
            index.put(enroll[i], i);
        }
        
        for (int i = 0; i < seller.length; i++) {
            String now = seller[i];
            int profit = amount[i] * 100;
            
            while (!now.equals("-") && profit > 0) {
                int idx = index.get(now);
                int giveToParent = profit / 10;
                int keep = profit - giveToParent;
                
                result[idx] += keep;
                
                now = parent.get(now);
                profit = giveToParent;
            }
        }
        
        return result;
    }
}
