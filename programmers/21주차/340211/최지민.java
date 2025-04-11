import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        Map<String, Integer> moveMap = new HashMap<>();
        int answer = 0;
        
        for(int i = 0; i < routes.length; i++) {
            int[] r = routes[i];
            int time = 0;
            
            int[] start = points[r[0] - 1];
            String key = time + ":" + start[0] + "_" + start[1];
            moveMap.put(key, moveMap.getOrDefault(key, 0) + 1);
            
            for(int j = 1; j < r.length; j++) {
                int[] end = points[r[j] - 1];
                
                int x = start[0], y = start[1];
                int endX = end[0], endY = end[1];
                
                while(x != endX) {
                    x += (endX > x) ? 1 : -1;
                    time++;
                    String keyX = time + ":" + x + "_" + y;
                    moveMap.put(keyX, moveMap.getOrDefault(keyX, 0) + 1);
                }
                
                while(y != endY) {
                    y += (endY > y) ? 1 : -1;
                    time++;
                    String keyY = time + ":" + x + "_" + y;
                    moveMap.put(keyY, moveMap.getOrDefault(keyY, 0) + 1);
                }
                
                start = end;
            }
        }
        
        for(int cnt : moveMap.values()) {
            if(cnt >= 2) answer++;
        }
      
        return answer;
    }
}