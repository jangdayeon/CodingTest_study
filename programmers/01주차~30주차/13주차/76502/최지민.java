import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for(int i = 0; i < s.length(); i++) {
            Deque<Character> stack = new ArrayDeque<>();
            boolean isValid = true;
            
            for(char peekChar : s.toCharArray()) {
                if(peekChar == ')' || peekChar == '}' || peekChar == ']') {
                    if(!stack.isEmpty() && isMatch(peekChar, stack.peekLast())) {
                        stack.pollLast();
                    } else {
                        isValid = false;
                        break;
                    }
                } else {
                    stack.offer(peekChar);
                }
            }
            
            if(isValid && stack.isEmpty()) {
                answer++;
            }
            
            s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
        }
        
        return answer;
    }
    
    private boolean isMatch(char peekChar, char peekLast) {
        return peekChar == ')' && peekLast == '(' ||
            peekChar == '}' && peekLast == '{' ||
            peekChar == ']' && peekLast == '[';
    }
}