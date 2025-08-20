import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        Arrays.sort(timetable);
        
        int current = 9 * 60, boarding = 0, boardingCnt = 0, lastTime = 0;
        for(int i = 0; i < n; i++) {
            boardingCnt = 0;
            
            while(boarding < timetable.length) {
                String[] time = timetable[boarding].split(":");
                int splitT = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
                
                if(splitT <= current && boardingCnt < m) {
                    boarding++;
                    boardingCnt++;
                    lastTime = splitT;
                }
                else break;
            }
            if(i == n - 1) {
                answer = (boardingCnt == m) ? toString(lastTime - 1) : toString(current);
            }
            current += t;
            
        }
        
        return answer;
    }
    
    private String toString(int time) {
        return String.format("%02d", time / 60) + ":" + String.format("%02d", time % 60);
    }
}