class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        long r1Long = (long)r1, r2Long = (long)r2;
        
        for(long i = 1; i <= r2; i++) {
            long minY = (r1 <= i) ? 0 : (long)Math.ceil(Math.sqrt((r1Long * r1Long) - (i * i)));
            long maxY = (long)Math.floor(Math.sqrt((r2Long * r2Long) - (i * i)));
            
            answer += (maxY - minY + 1);
        }
        
        return (answer) * 4;
    }
}