import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> answer = new ArrayList<>();
        
        for(long i = left; i <= right; i++) {
            if(i / n >= i % n) answer.add((int) (i / n) + 1);
            else answer.add((int) (i % n) + 1);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}