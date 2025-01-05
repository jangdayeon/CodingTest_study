import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Integer, Integer> hm = new HashMap<>();
        for(int w : weights){
            if(hm.containsKey(w)){
                hm.replace(w,hm.get(w)+1);
            } else{
                hm.put(w,1);
            }
        }
        Integer[] keys = hm.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);
        for(int i=0; i<keys.length;i++){
            int now = keys[i];
            int cnt = hm.get(now);
            answer += (long) cnt*(cnt-1)/2;
            for(int j=i+1; j<keys.length; j++){
                int next = keys[j];
                if(now*3 == next*2 ||
                    now*4 == next*2 ||
                    now*4 == next*3){
                    answer += (long) cnt*hm.get(next);
                }
            }
        }
        return answer;
    }
}