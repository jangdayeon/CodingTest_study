class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long r = (long) d * d;
        
        for(long i = 0; i <= d; i += k) {
            long y = (long) Math.sqrt(r - (i * i));
            answer += (y / k) + 1;
        }
        
        return answer;
    }
}