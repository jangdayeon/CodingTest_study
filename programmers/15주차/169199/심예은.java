import java.util.*;

class Solution {
    public int solution(String[] board) {
        int n = board.length, m = board[0].length();
        char[][] map = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        // 시작 위치 찾기
        for (int i = 0; i < n; i++) {
            map[i] = board[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'R') {
                    queue.offer(new int[]{i, j, 0}); // 시작 위치와 이동 횟수
                    visited[i][j] = true;
                }
            }
        }

        // 상하좌우 방향
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], moves = cur[2];

            // 목표 지점 도달
            if (map[x][y] == 'G') return moves;

            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = x, ny = y;

                // 벽이나 장애물을 만나기 전까지 이동
                while (nx + dx[d] >= 0 && nx + dx[d] < n && ny + dy[d] >= 0 && ny + dy[d] < m
                        && map[nx + dx[d]][ny + dy[d]] != 'D') {
                    nx += dx[d];
                    ny += dy[d];
                }

                // 방문하지 않았다면 큐에 추가
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, moves + 1});
                }
            }
        }
        return -1; // 도달 불가능
    }
}