import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int totalTime = logsToSec(play_time);
        long[] timeTable = new long[totalTime + 2];
        
        // 차분 배열: https://sheep1sik.tistory.com/161
        for(String log : logs) {
            String[] logSplit = log.split("-");
            timeTable[logsToSec(logSplit[0])] += 1;
            timeTable[logsToSec(logSplit[1])] -= 1;
        }
        
        // 각 초에 몇 명이 시청 중인지
        for(int i = 1; i < totalTime; i++) {
            timeTable[i] += timeTable[i - 1];
        }
        
        // 누적 시청시간
        long[] total = new long[totalTime];
        total[0] = timeTable[0];
        for(int i = 1; i < totalTime; i++) {
            total[i] = total[i - 1] + timeTable[i];
        }
        
        long maxTime = -1;
        long startTime = -1;
        int advTimeToSec = logsToSec(adv_time);
        for(int i = 0; i <= totalTime - advTimeToSec; i++) {
            int end = i + advTimeToSec - 1;
            
            // 시작부터 ~ 이전까지 빼서 누적합 구하기
            long cnt = total[end] - (i == 0 ? 0 : total[i - 1]);
            
            if(maxTime < cnt) {
                maxTime = cnt;
                startTime = i;
            }
        }
        
        return (maxTime == -1) ? "00:00:00" : secToString(startTime);
    }
    
    private int logsToSec(String time) {
        String[] timeSplit = time.split(":");
        
        return Integer.parseInt(timeSplit[0]) * 3600 
            + Integer.parseInt(timeSplit[1]) * 60 
            + Integer.parseInt(timeSplit[2]);
    }
    
    private String secToString(long sec) {
        long h = sec / 3600; sec %= 3600;
        long m = sec / 60; sec %= 60;
        
        return String.format("%02d:%02d:%02d", h, m, sec);
    }
}