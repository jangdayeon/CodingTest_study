import java.math.*;

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        
        // 각 바늘의 속도
        BigDecimal hSpeed = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(120), 20, RoundingMode.HALF_UP); // 시침
        BigDecimal mSpeed = BigDecimal.valueOf(0.1);  // 분침
        BigDecimal sSpeed = BigDecimal.valueOf(6); // 초침

        BigDecimal now = convertToSec(h1,m1,s1);
        BigDecimal end = convertToSec(h2,m2,s2);
        
        BigDecimal beforeHAngle = hSpeed.multiply(now).remainder(BigDecimal.valueOf(360));
        BigDecimal beforeMAngle = mSpeed.multiply(now).remainder(BigDecimal.valueOf(360));
        BigDecimal beforeSAngle = sSpeed.multiply(now).remainder(BigDecimal.valueOf(360));
        
        if(beforeSAngle.compareTo(beforeMAngle) == 0 || 
          beforeSAngle.compareTo(beforeHAngle) == 0 ) answer++;
        now = now.add(BigDecimal.valueOf(1));
        boolean t = true;
        while(now.compareTo(end) <= 0){
            BigDecimal hAngle = hSpeed.multiply(now).remainder(BigDecimal.valueOf(360)); // 시침 각도
            BigDecimal mAngle = mSpeed.multiply(now).remainder(BigDecimal.valueOf(360)); // 분침 각도
            BigDecimal sAngle = sSpeed.multiply(now).remainder(BigDecimal.valueOf(360)); // 초침 각도
            
            //정각 지나가는 거 해결하려고
            hAngle = hAngle.compareTo(BigDecimal.valueOf(0)) == 0 ? hAngle.add(BigDecimal.valueOf(360)) : hAngle;
            mAngle = mAngle.compareTo(BigDecimal.valueOf(0)) == 0 ? mAngle.add(BigDecimal.valueOf(360)) : mAngle;
            sAngle = sAngle.compareTo(BigDecimal.valueOf(0)) == 0 ? sAngle.add(BigDecimal.valueOf(360)) : sAngle;
            
            if (beforeSAngle.compareTo(beforeHAngle) < 0 && sAngle.compareTo(hAngle) >= 0) {
                answer++;
            } 
            if (beforeSAngle.compareTo(beforeMAngle) < 0 && sAngle.compareTo(mAngle) >= 0) {
                answer++;
            }
            if (beforeMAngle.compareTo(beforeHAngle) < 0 && mAngle.compareTo(hAngle) >= 0
               && beforeSAngle.compareTo(beforeHAngle) < 0 && sAngle.compareTo(hAngle) >= 0) {
                answer--;
            }
            
            beforeHAngle = hAngle.remainder(BigDecimal.valueOf(360));;
            beforeMAngle = mAngle.remainder(BigDecimal.valueOf(360));;
            beforeSAngle = sAngle.remainder(BigDecimal.valueOf(360));;
            
            now = now.add(BigDecimal.valueOf(1));
        }
        return answer;
    }
    
    private BigDecimal convertToSec(int h, int m, int s){
        return new BigDecimal(h * 60 * 60 + m * 60 + s);
    }
}