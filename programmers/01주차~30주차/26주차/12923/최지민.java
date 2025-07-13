class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin) + 1];
        
        for(long i = begin; i <= end; i++) {
            if(i == 1) answer[(int)(i - begin)] = 0;
            else answer[(int)(i - begin)] = divisor(i);
        }
        
        return answer;
    }
    
    private int divisor(long num) {
        int maxDivisor = 1;
        
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if((int)(num % i) == 0) {
                maxDivisor = Math.max((int)(num / i) > 10_000_000 ? i : (int)(num / i), maxDivisor);
            }
        }
        
        return maxDivisor;
    }
}