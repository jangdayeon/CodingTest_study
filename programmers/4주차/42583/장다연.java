//빡구현
import java.util.*;
import java.lang.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        for(int i=0;i<bridge_length;i++){
            bridge.add(0);
        }
        
        int tw_idx = 0;
        int now = bridge.stream().reduce(0,(a,b)->a+b);
        while(bridge.size()!=0){
            answer += 1;
            bridge.remove();
            now = bridge.stream().reduce(0,(a,b)->a+b);
            if(tw_idx >= truck_weights.length){
                continue;
            }
            if(now+truck_weights[tw_idx] >  weight) {
                bridge.add(0);
            } else {
                    bridge.add(truck_weights[tw_idx]);
                    tw_idx +=1;
            }
        }
        return answer;
    }
}