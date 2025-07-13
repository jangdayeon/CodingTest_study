import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int w : works) {
            pq.add(w);
        }
        
        while(n > 0) {
            int max = pq.poll();
            if(max <= 0) break;
            
            pq.add(max - 1);
            n--;
        }
        
        for(int time : pq) {
            answer += (time > 0) ? time * time : 0;
        }
        
        return answer;
    }
}