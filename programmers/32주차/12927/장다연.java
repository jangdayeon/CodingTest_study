//야근 피로도 = 남은 일의 작업량 ** 2
import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int w : works){
            pq.add(w);
        }
        while(n-- > 0 && pq.peek() != 0){
            int a = pq.remove();
            pq.add(a-1);
        }
        for(int i : pq){
            answer += Math.pow(i, 2);
        }
        return answer;
    }
}