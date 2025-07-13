import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char x : s.toCharArray()) {
            if (!deque.isEmpty() && deque.peek().equals(x)) {
                deque.pop();
            } else {
                deque.push(x);
            }
        }

        return deque.isEmpty() ? 1 : 0;
    }
}