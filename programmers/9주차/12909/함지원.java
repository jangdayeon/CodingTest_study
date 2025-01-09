import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char x : s.toCharArray()) {
            if (x == '(') stack.push(x);
            else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}