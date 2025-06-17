import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        
        for(int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        int now = 0, sum = 0;
        
        while(now < truck_weights.length) {
            answer++;
            
            sum -= bridge.poll();
            
            if(sum + truck_weights[now] <= weight) {
                bridge.add(truck_weights[now]);
                sum += truck_weights[now];
                
                now++;
            } else {
                bridge.add(0);
            }
        }
        
        return answer + bridge_length;
    }
}