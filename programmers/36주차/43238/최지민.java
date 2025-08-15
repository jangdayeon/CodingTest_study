import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long right = (long) Arrays.stream(times).max().getAsInt() * n;
        long left = 0, mid = (left + right) / 2;
        while(left <= right) {
            // mid 시간 안에 n명을 처리할 수 있는가
            mid = (left + right) / 2;
            long people = 0;
            
            for(int time : times) {
                people += (mid / time);
            }
            
            if(n <= people) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
            
        return answer;
    }
}