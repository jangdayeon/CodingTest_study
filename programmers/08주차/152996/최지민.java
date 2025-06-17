import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        HashMap<Integer, Long> weightMap = new HashMap<>();
        
        for(int w : weights) {
            weightMap.put(w, weightMap.getOrDefault(w, 0L) + 1);
        }
        
        Integer[] weightKey = weightMap.keySet().toArray(new Integer[0]);
        Arrays.sort(weightKey);
        
        int[][] distance = {{2, 2}, {3, 2}, {4, 2}, {4, 3}};
        
        for(int i = 0; i < weightKey.length; i++) {
            for(int j = i + 1; j < weightKey.length; j++) {
                for(int[] d : distance) {
                    if(weightKey[i] * d[0] == weightKey[j] * d[1]) {
                        answer += (weightMap.get(weightKey[i]) * weightMap.get(weightKey[j]));
                    }
                }
            }
        }
        
        for(Map.Entry<Integer, Long> entry : weightMap.entrySet()) {
            Long value = entry.getValue();
            
            if(value > 1) {
                answer += ((value * (value - 1)) / 2);
            }
        }
        
        return answer;
    }
}