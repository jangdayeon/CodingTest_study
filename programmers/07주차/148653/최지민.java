import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        int current = 0;
        int next = 0;
        
        while(storey > 0) {
            current = storey % 10 + next;
            next = 0;
            
            if(current > 5 || ((current == 5) && (((storey / 10) % 10) + 1 > 5))) {
                answer += (10 - current);
                next = 1;
            } else {
                answer += current;
            }
            
            storey /= 10;
        }
        
        return (current > 5) ? answer + 1 : answer;
    }
}