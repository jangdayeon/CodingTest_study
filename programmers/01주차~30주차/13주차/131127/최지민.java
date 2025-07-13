import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> martDiscount = new HashMap<>();
        
        for(int i = 0; i < discount.length; i++) {
            martDiscount.put(discount[i], martDiscount.getOrDefault(discount[i], 0) + 1);
            if(i >= 10) {
                martDiscount.replace(discount[i - 10], martDiscount.get(discount[i - 10]) - 1);
            }
            
            boolean isMember = true;
            for(int j = 0; j < want.length; j++) {
                if(!martDiscount.containsKey(want[j]) || martDiscount.get(want[j]) != number[j]) {
                    isMember = false;
                    break;
                }
            }
    
            if(isMember) answer++;
        }
        
        return answer;
    }
}