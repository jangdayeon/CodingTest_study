import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // 짝이 맞으면 제거
            } else {
                stack.push(c); // 스택에 추가
            }
        }

        // 스택이 비어있으면 모든 문자를 제거한 상태
        return stack.isEmpty() ? 1 : 0;
    }
}
