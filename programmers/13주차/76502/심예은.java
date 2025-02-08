import java.util.*;

public class Solution {
    public int solution(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, s.length()) + s.substring(0, i);

            // 회전한 문자열이 올바른 괄호 문자열인지 확인
            if (isValid(str)) {
                count++;
            }
        }
        return count;
    }

    // 올바른 괄호 문자열인지 확인하는 메서드
    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); // 이전 괄호 상태를 기억하기 위해 Stack을 사용 → 순서가 유지됨.
        Map<Character, Character> pairs = Map.of('(', ')', '{', '}', '[', ']');

        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) { // 여는 괄호인지 확인
                stack.push(c);
            } else { // 닫는 괄호일 경우
                if (stack.isEmpty() || pairs.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}