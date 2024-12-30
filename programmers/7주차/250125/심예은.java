class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;  // 격자의 크기
        String targetColor = board[h][w];  // 고른 칸의 색
        int count = 0;  // 같은 색의 이웃한 칸 개수

        // 방향 벡터 (상하좌우)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];

            // 유효한 좌표인지 확인
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                // 같은 색인 경우 count 증가
                if (board[nx][ny].equals(targetColor)) {
                    count++;
                }
            }
        }
        return count;  // 결과 반환
    }
}