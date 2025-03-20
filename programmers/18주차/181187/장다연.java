//원의 방정식 : (x - a)2 + (y - b)2 = r2
//r1이 작은 원
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        //1사분면만 확인
        for(int i=1; i<r2; i++){ //x
            long y1 = r1 < i ? 0 : (long) Math.ceil(Math.sqrt(((long)r1*r1) - (long)i*i));
            long y2 = (long) Math.floor(Math.sqrt(((long)r2*r2) - (long)i*i));
            answer += y2-y1 + 1;            
        }
        answer = answer * 4 + 4;
        return answer;
    }
}