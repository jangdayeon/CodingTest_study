import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
       
        int[][] intBookTime = new int[book_time.length][2];
        
        for(int i = 0; i < book_time.length; i++) {
            intBookTime[i][0] = timeToMin(book_time[i][0]);
            intBookTime[i][1] = timeToMin(book_time[i][1]);
        }
        
        Arrays.sort(intBookTime, (a, b) -> a[0] - b[0]);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        boolean flag = false;
        
        for(int[] time : intBookTime) {
            for(int room : map.keySet()) {
                if(map.get(room) <= time[0]) {
                    map.put(room, time[1] + 10);
                    flag = true;
                    break;
                }
            }
            
            if(!flag) {
                answer++;
                map.put(answer, time[1] + 10);
            }
            
            flag = false;
        }
        
        return answer;
    }
    
    private int timeToMin(String time) {
        String[] timeSplit = time.split(":");
        return Integer.valueOf(timeSplit[0]) * 60 + Integer.valueOf(timeSplit[1]);
    }
}