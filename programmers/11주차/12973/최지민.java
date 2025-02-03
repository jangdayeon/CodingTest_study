import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        
        for(char ch : s.toCharArray()) {
            if(deque.isEmpty() || ch != deque.peek()) {
                deque.offerFirst(ch);
            } else if(ch == deque.peek()) {
                deque.poll();
            }
        }
       
        return deque.isEmpty() ? 1 : 0;
    }
}