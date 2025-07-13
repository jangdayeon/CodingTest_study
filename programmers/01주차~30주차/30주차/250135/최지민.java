class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        
        double start = h1 * 3600 + m1 * 60 + s1;
        double end = h2 * 3600 + m2 * 60 + s2;
        
        if(start == 0 || start == 12 * 3600) answer++;
        
        while(start < end) {
            double[] startDeg = secToDeg(start);
            double[] nextDeg = secToDeg(start + 1);
            
            nextDeg[0] = nextDeg[0] == 0 ? 360 : nextDeg[0];
            nextDeg[1] = nextDeg[1] == 0 ? 360 : nextDeg[1];
            nextDeg[2] = nextDeg[2] == 0 ? 360 : nextDeg[2];
            
            if(startDeg[2] < startDeg[0] && nextDeg[2] >= nextDeg[0]) answer++;
            if(startDeg[2] < startDeg[1] && nextDeg[2] >= nextDeg[1]) answer++;
            
            if(nextDeg[1] == nextDeg[0] && nextDeg[0] == nextDeg[2]) answer--;
            
            start++;
        }
        
        return answer;
    }
    
    private double[] secToDeg(double sec) {
        double h = sec * (1.0 / 120) % 360;
        double m = sec * 0.1 % 360;
        double s = sec * 6 % 360;
        
        return new double[]{h, m, s};
    }
}