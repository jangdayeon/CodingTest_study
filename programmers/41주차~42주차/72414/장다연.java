import java.util.*;
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSec = timeToSec(play_time.split(":"));
        int advSec = timeToSec(adv_time.split(":"));
        
        long[] total = new long[playSec+1];
        
        int[][] logsConverted = new int[logs.length][2];
        for(int i=0; i<logs.length; i++){
            int[] sec = logToSec(logs[i]);
            //초 : 0 1 2 3 4 5
            //값 : 0 +1 -1 0 0 0
            total[sec[0]] += 1;
            total[sec[1]] -= 1;
        }
        
        for(int i=1; i<=playSec; i++){
            //초 : 0 1 2 3 4 5
            //값 : 0 1 1 0 0 0
            total[i] += total[i-1];
        }
        
        for(int i=1; i<=playSec; i++){
            //초 : 0 1 2 3 4 5
            //값 : 0 1 2 2 2 2 
            total[i] += total[i-1];
        }
        
        long max = total[advSec-1];
        int answer = 0;
        for(int i= advSec; i <= playSec; i++){
            long now = total[i] - total[i-advSec];
            if(now > max){
                max = now;
                answer = i - advSec + 1;
            }
        }
        
        return secToTime(answer);
    }
    private String secToTime(int sec){
        int h = sec / 3600;
        int m = (sec % 3600) / 60;
        int s = (sec % 3600) % 60;
        return (h<10?"0":"")+h+":"+(m<10?"0":"")+m+":"+(s<10?"0":"")+s;
    }
    private int[] logToSec(String log){
        String[] logSplited = log.split("[:-]");
        int[] rtn = new int[2];
        rtn[0] = timeToSec(new String[]{logSplited[0],logSplited[1],logSplited[2]});
        rtn[1] = timeToSec(new String[]{logSplited[3],logSplited[4],logSplited[5]});
        return rtn;
    }
    private int timeToSec(String[] time){
        return Integer.parseInt(time[0])*3600+Integer.parseInt(time[1])*60+Integer.parseInt(time[2]);
    }
}