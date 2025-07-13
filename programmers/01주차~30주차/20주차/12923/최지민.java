import java.util.*;

class Solution {
    private long getDivisor(long a) {
        if(a == 1) return 0;
        
        long result = 1;
        
        for(long i = 2; i <= Math.sqrt(a); i++) {
            if(a % i == 0) {
                result = Math.max(result, i);
                if((a / i) <= 10_000_000) result = Math.max(result, (a / i));
            }
        }
        
        return result;
    }
    
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin) + 1];
        
        long num = begin;
        for(int i = 0; i < answer.length; i++) {
            answer[i] = (int)getDivisor(num);
            num++;
        }
        
        return answer;
    }
}