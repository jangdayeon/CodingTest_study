public class Solution {
    public String solution(String p) {
        // 1. 입력이 빈 문자열이면 그대로 반환
        if (p.isEmpty()) return p;

        // 2. u, v로 분리
        int balance = 0, i = 0;
        do {
            balance += (p.charAt(i) == '(') ? 1 : -1;
            i++;
        } while (balance != 0);

        String u = p.substring(0, i);
        String v = p.substring(i);

        // 3. u가 올바른 괄호 문자열이면 v에 대해 재귀 호출
        if (isCorrect(u)) return u + solution(v);

        // 4. u가 올바르지 않은 경우 변환
        return "(" + solution(v) + ")" + reverse(u);
    }

    // 올바른 괄호 문자열인지 확인
    private boolean isCorrect(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            balance += (c == '(') ? 1 : -1;
            if (balance < 0) return false; // ')'가 먼저 나오면 false
        }
        return true;
    }

    // 괄호 방향 반전 (첫 번째, 마지막 문자 제거 후 나머지 변환)
    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length() - 1; i++) {
            sb.append(s.charAt(i) == '(' ? ')' : '(');
        }
        return sb.toString();
    }
}
