class Solution {
    public int[] solution(int n) {
        // 삼각형의 총 원소 개수
        int total = n * (n + 1) / 2;
        int[] answer = new int[total];

        // 삼각형 구조를 저장할 2D 배열
        int[][] triangle = new int[n][n];

        // 방향 제어를 위한 변수 (0: 아래, 1: 오른쪽, 2: 대각선)
        int[] dx = {1, 0, -1}; // x 방향 이동
        int[] dy = {0, 1, -1}; // y 방향 이동

        int x = 0, y = 0, num = 1, dir = 0; // 초기 상태

        while (num <= total) {
            triangle[x][y] = num++; // 현재 위치에 숫자 채우기

            // 다음 좌표 계산
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 다음 좌표가 범위를 벗어나거나 이미 값이 있으면 방향 전환
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || triangle[nx][ny] != 0) {
                dir = (dir + 1) % 3; // 다음 방향으로 전환
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            // 좌표 업데이트
            x = nx;
            y = ny;
        }

        // 결과 배열로 변환
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) { // 삼각형 구조
                answer[index++] = triangle[i][j];
            }
        }

        return answer;
    }
}
