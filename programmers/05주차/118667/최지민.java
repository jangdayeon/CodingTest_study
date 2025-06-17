import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Deque<Long> q1 = new LinkedList<>();
        Deque<Long> q2 = new LinkedList<>();
        
        for(int q : queue1) q1.add((long) q);
        for(int q : queue2) q2.add((long) q);
        
        long q1Sum = Arrays.stream(queue1).sum();
        long q2Sum = Arrays.stream(queue2).sum();
        
        if((q1Sum + q2Sum) % 2 != 0) return -1;
        
        int q1Answer = 0;
        int q2Answer = 0;
        
        while(q1Sum != q2Sum) {
            if(q1Sum > q2Sum) {
                long tmp = q1.remove();
                q2.add(tmp);
                
                q1Sum -= tmp;
                q2Sum += tmp;
                
                q1Answer++;
            } else {
                long tmp = q2.remove();
                q1.add(tmp);
                
                q2Sum -= tmp;
                q1Sum += tmp;
                
                q2Answer++;
            }
            
            if(q1Answer >= (queue1.length * 3) || q2Answer >= (queue2.length * 3)) return -1;
        }
        
        return q1Answer + q2Answer;
    }
}