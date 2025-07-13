class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] n = name.toCharArray();
        int y;
        int move = n.length - 1; // 그냥 오른쪽으로만 끝까지 가는 경우의 기본값

        for (int x = 0; x < n.length; x++) {

            // [1] 상하 조작: A에서 n[x]까지 바꾸는 최소 횟수 더하기
            answer += Math.min(n[x] - 'A', 'Z' - n[x] + 1);

            // [2] 이 위치 x 이후로 연속된 A가 얼마나 나오는지 확인
            y = x + 1;
            while (y < n.length && n[y] == 'A') {
                y++; // y는 연속된 A가 끝나는 지점
            }

            // [3] 이 위치까지 갔다가 돌아서 다른 방향으로 가는 경우 중 최소 이동 계산(뭉탱이를 기준으로 왼 Or 오 중 어느쪽으로 이동하는 것이
            // 최적인지)
            // 왼쪽 먼저 갔다가 오른쪽: x + x + (n.length - y)
            // 오른쪽 갔다가 왼쪽: x + 2*(n.length - y)
            move = Math.min(move, Math.min(x + x + (n.length - y), (n.length - y) * 2 + x));
        }

        return answer + move; // 상하조작 + 최적 좌우이동
    }
}