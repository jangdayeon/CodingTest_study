import java.util.*;

class Solution {
    static class Point {
        int x, y, answer;

        Point(int x, int y, int answer) {
            this.x = x;
            this.y = y;
            this.answer = answer;
        }
    }

    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();

        char[][] map = new char[n][m];
        boolean[][] visited = new boolean[n][m];

        int xStart = 0, yStart = 0, xGoal = 0, yGoal = 0;

        for (int i = 0; i < n; i++) {
            // 시작 위치 찾기
            map[i] = board[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'R') {
                    xStart = i;
                    yStart = j;
                }

                if (map[i][j] == 'G') {
                    xGoal = i;
                    yGoal = j;
                }
            }
        }

        // BFS 탐색을 위한 Queue
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(xStart, yStart, 0));
        visited[xStart][yStart] = true;

        // 상하좌우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            // goal 지점 도착
            if (cur.x == xGoal && cur.y == yGoal) return cur.answer;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x;
                int ny = cur.y;

                while (true) {
                    int xNext = nx + dx[i];
                    int yNext = ny + dy[i];

                    // 범위를 벗어나거나 장애물에 부딪히면 종료
                    if (xNext < 0 || xNext >= n || yNext < 0 || yNext >= m || map[xNext][yNext] == 'D') break;

                    // 위치 갱신
                    nx = xNext;
                    ny = yNext;
                }

                // 이미 방문한 곳이면 스킵
                if (visited[nx][ny]) continue;

                // 방문 체크 후 queue 추가
                visited[nx][ny] = true;
                queue.add(new Point(nx, ny, cur.answer + 1));
            }
        }

        return -1;
    }
}