
import java.util.Stack;

public class Solution {
    public static String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        // 숫자를 하나씩 확인
        for (char digit : number.toCharArray()) {
            // 스택의 마지막 값보다 큰 값을 만나면 제거 (k가 남아있을 때만)
            while (!stack.isEmpty() && stack.peek() < digit && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // 제거 횟수가 남아 있으면 뒤에서 k개 제거
        while (k > 0) {
            stack.pop();
            k--;
        }

        // 스택의 값을 합쳐서 문자열로 변환
        StringBuilder result = new StringBuilder();
        for (char digit : stack) {
            result.append(digit);
        }

        return result.toString();
    }
}