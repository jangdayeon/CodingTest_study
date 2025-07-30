import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1, right = 200_000_000, mid = (left + right) / 2;
        
        while(left <= right) {
            mid = (left + right) / 2;
            
            if(check(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private boolean check(int[] stones, int k, int mid) {
        int cnt = 0;
        
        for(int i = 0; i < stones.length; i++) {
            if(stones[i] - mid < 0) {
                cnt++;
                if(cnt >= k) return false;
            } else {
                cnt = 0;
            }
        }
        
        return true;
    }
}