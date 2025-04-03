import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int deliverSum = 0;
        int pickupSum = 0;
        
        for(int i = deliveries.length - 1; i > -1; i--) {
            deliverSum += deliveries[i];
            pickupSum += pickups[i];
            
            while(deliverSum > 0 || pickupSum > 0) {
                answer += (i + 1) * 2;
                
                deliverSum -= cap;
                pickupSum -= cap;
            }
        }
        
        return answer;
    }
}