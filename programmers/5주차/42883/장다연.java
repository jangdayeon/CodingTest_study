import java.util.*;

class Solution {
    public String solution(String number, int k) {
        // 숫자 리스트로 변환
        List<Character> nums = new ArrayList<>();
        for (char c : number.toCharArray()) {
            nums.add(c);
        }

        // 스택을 사용하여 값 제거
        int size = number.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < size; i++) {
            char current = nums.get(i);

            // 스택이 비어 있지 않고, 스택의 마지막 값이 현재 값보다 작다면
            // 스택에서 값을 제거하고 k를 감소시킴
            while (k > 0 && !stack.isEmpty() && stack.peek() < current) {
                stack.pop();
                k--;
            }

            // 스택에 현재 값을 추가
            stack.push(current);
        }

        // 남은 값에서 k번 만큼 마지막에 있는 값 제거
        while (k > 0) {
            stack.pop();
            k--;
        }

        // 스택의 값들을 문자열로 반환
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
