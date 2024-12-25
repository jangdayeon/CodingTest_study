public class Solution {
    public static int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        // 2차원 배열 초기화
        int[][] triangle = new int[n][n];
        int num = 1; // 채울 숫자
        int x = -1, y = 0; // 시작 위치 (아래로 이동하면서 시작)

        // 반시계 방향으로 숫자 채우기
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // 방향에 따라 좌표를 움직임
                if (i % 3 == 0) { // 아래로 이동
                    x++;
                } else if (i % 3 == 1) { // 오른쪽으로 이동
                    y++;
                } else if (i % 3 == 2) { // 위로 이동
                    x--;
                    y--;
                }
                triangle[x][y] = num++; // 숫자 채우기
            }
        }

        int k = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(triangle[i][j] == 0) break;
                answer[k++] = triangle[i][j];
            }
        }
        return answer;
    }
}