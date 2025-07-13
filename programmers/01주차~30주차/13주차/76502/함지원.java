import java.util.*;

public class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i) + s.substring(0, i);
            if (isCollect(sub)) answer++;
        }

        return answer;
    }

    public boolean isCollect(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                deque.push(s.charAt(i));
            } else {
                if (deque.isEmpty()) return false;

                char pop = deque.pop();
                if (
                        (s.charAt(i) == ']' && pop != '[') ||
                                (s.charAt(i) == '}' && pop != '{') ||
                                (s.charAt(i) == ')' && pop != '(')
                ) return false;
            }
        }

        return deque.isEmpty();
    }
}