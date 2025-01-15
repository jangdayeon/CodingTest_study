import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] charArr = s.toCharArray();
        
        for(char c : charArr) {
            if(c == ')') {
                if(!deque.isEmpty() && deque.peekLast() == '(') deque.removeLast();
                else return false;
            } else {
                deque.offer('(');
            }
        }
        
        return deque.isEmpty() ? true : false;
    }
}