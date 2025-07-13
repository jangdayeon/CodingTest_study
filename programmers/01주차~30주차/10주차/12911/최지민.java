import java.util.*;

class Solution {
    public int solution(int n) {
        int oneCnt = Integer.bitCount(n);
        
        while(true) {
            n++;
            
            if(Integer.bitCount(n) == oneCnt) break;
        }
        
        return n;
    }
}