import java.util.*;

class Time {
    double h;
    double m;
    double s;

    void calcDeg(double timeS) {
        this.h = timeS * (1.0 / 120) % 360;
        this.m = timeS * 0.1 % 360;
        this.s = timeS * 6 % 360;
    }
    
    void nextDeg(double timeS) {
        this.h = (timeS * (1.0 / 120) % 360 == 0) ? 360 : timeS * (1.0 / 120) % 360;
        this.m = (timeS * 0.1 % 360 == 0) ? 360 : timeS * 0.1 % 360;
        this.s = (timeS * 6 % 360 == 0) ? 360 : timeS * 6 % 360;
    }
}

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        
        double start = h1 * 3600 + m1 * 60 + s1;
        double end = h2 * 3600 + m2 * 60 + s2;
        
        if(start == 0 || start == 12 * 3600) answer++;
        
        Time startTime = new Time();
        Time nextTime = new Time();
        
        while(start < end) {
            startTime.calcDeg(start);
            nextTime.nextDeg(start + 1);
            
            if(startTime.h > startTime.s && nextTime.h <= nextTime.s) answer++;
            
            if(startTime.m > startTime.s && nextTime.m <= nextTime.s) answer++;
            
            if(nextTime.m == nextTime.s && nextTime.s == nextTime.h) {
                answer--;
            }
            
            start++;
        }
        
        return answer;
    }
}