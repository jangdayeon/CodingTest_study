import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        HashMap<Integer, int[]> point = new HashMap<>();
        for(int i = 0; i < points.length; i++) {
            point.put(i + 1, new int[]{points[i][0], points[i][1]});
        }
        
        HashMap<Integer, List<int[]>> pos = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            int sec = 1;
            
            int[] start = point.get(routes[i][0]);
            int[] end = new int[2];
            
            int x = start[0], y = start[1];
            
            pos.computeIfAbsent(0, t -> new ArrayList<>()).add(new int[]{x, y});
            
            for(int j = 0; j < routes[0].length; j++) {
                end = point.get(routes[i][j]);
                
                int dx = (x > end[0]) ? -1 : 1;
                for(int k = 0; k < Math.abs(end[0] - start[0]); k++) {
                    x += dx;
                    pos.computeIfAbsent(sec, t -> new ArrayList<>()).add(new int[]{x, y});
                    sec++;
                }
                
                int dy = (y > end[1]) ? -1 : 1;
                for(int k = 0; k < Math.abs(end[1] - start[1]); k++) {
                    y += dy;
                    pos.computeIfAbsent(sec, t -> new ArrayList<>()).add(new int[]{x, y});
                    sec++;
                }
               
                start = end;
            }
        }
        
        for(Integer key : pos.keySet()) {
            Map<String, Integer> cnt = new HashMap<>();
            
            for(int[] p : pos.get(key)) {
                String k = p[0] + "," + p[1];
                cnt.put(k, cnt.getOrDefault(k, 0) + 1);
            }
            
            for(String cntKey : cnt.keySet()) {
                if(cnt.get(cntKey) >= 2) answer++;
            }
        }
        
        return answer;
    }
}