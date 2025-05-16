public class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1;  // 기본적으로 오른쪽으로 끝까지 이동하는 경우

        // 각 문자에 대해 최소 조작 횟수를 더해간다.
        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            // 위, 아래로 조작하는 최소 횟수
            answer += getMinUpDownMoves(c);

            // 'A'가 아닌 문자가 연속되는 구간을 건너뛰기 위해 이동 최소 횟수 계산
            int j = i + 1;
            while (j < len && name.charAt(j) == 'A') {
                j++;
            }

            // 좌우 이동 최소 횟수 갱신
            move = Math.min(move, i + len - j + Math.min(i, len - j));
        }

        return answer + move;
    }

    // 위, 아래 조작 최소값 계산
    private int getMinUpDownMoves(char c) {
        return Math.min(c - 'A', 26 - (c - 'A'));
    }
}
