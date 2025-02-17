import java.util.*;

class Solution {
    public String solution(String p) {
        if (p.isEmpty()) return "";

        int idx = isBalanced(p);
        String u = p.substring(0, idx + 1);
        String v = p.substring(idx + 1);

        if (isValid(u)) return u + solution(v);

        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(solution(v));
        sb.append(")");

        sb.append(reverse(u.substring(1, u.length() - 1)));

        return sb.toString();
    }

    public int isBalanced(String p) {
        int cnt = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') cnt++;
            else cnt--;

            if (cnt == 0) return i;
        }

        return -111;
    }

    public boolean isValid(String p) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char x : p.toCharArray()) {
            if (x == '(') stack.push(x);
            else {
                if (stack.isEmpty()) return false;
                if (x == ')') stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public String reverse(String p) {
        StringBuilder sb = new StringBuilder();

        for (char x : p.toCharArray()) {
            if (x == '(') sb.append(")");
            else sb.append("(");
        }

        return sb.toString();
    }
}