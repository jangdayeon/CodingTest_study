public class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1;

        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);

            answer += Math.min(c - 'A', 26 - (c - 'A'));

            int j = i + 1;
            while (j < len && name.charAt(j) == 'A') {
                j++;
            }

            move = Math.min(move, i + len - j + Math.min(i, len - j));
        }
        return answer + move;
    }
}
