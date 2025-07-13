import java.util.*;

public class Solution {
    public static int solution(String[] storage, String[] requests) {
        int n = storage.length;          // 행의 개수
        int m = storage[0].length();       // 열의 개수

        // 창고 상태를 2차원 char 배열로 생성합니다.
        // 컨테이너가 있는 경우 해당 알파벳, 제거된 경우 '.'으로 처리합니다.
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = storage[i].toCharArray();
        }

        // 상하좌우 네 방향 벡터
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        // 각 출고 요청을 순서대로 처리합니다.
        for (String req : requests) {
            // 요청 문자열의 첫 글자가 컨테이너 종류입니다.
            char containerType = req.charAt(0);

            // 요청 문자열의 길이에 따라 처리 방법 결정
            if (req.length() > 1) {
                // 크레인 방식: 해당 종류의 컨테이너를 모두 제거합니다.
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (grid[i][j] == containerType) {
                            grid[i][j] = '.';  // 제거된 컨테이너 표시 (빈 칸)
                        }
                    }
                }
            } else {
                // 지게차 방식: 접근 가능한 컨테이너만 제거합니다.
                // 1. 현재 창고에서 "외부와 연결된 빈 영역"을 찾습니다.
                boolean[][] accessibleEmpty = new boolean[n][m];
                Queue<int[]> queue = new LinkedList<>();

                // 격자 경계에 위치한 빈 칸들을 시작점으로 추가합니다.
                // 세로 경계 (왼쪽, 오른쪽)
                for (int i = 0; i < n; i++) {
                    if (grid[i][0] == '.' && !accessibleEmpty[i][0]) {
                        accessibleEmpty[i][0] = true;
                        queue.offer(new int[]{i, 0});
                    }
                    if (grid[i][m - 1] == '.' && !accessibleEmpty[i][m - 1]) {
                        accessibleEmpty[i][m - 1] = true;
                        queue.offer(new int[]{i, m - 1});
                    }
                }
                // 가로 경계 (위, 아래)
                for (int j = 0; j < m; j++) {
                    if (grid[0][j] == '.' && !accessibleEmpty[0][j]) {
                        accessibleEmpty[0][j] = true;
                        queue.offer(new int[]{0, j});
                    }
                    if (grid[n - 1][j] == '.' && !accessibleEmpty[n - 1][j]) {
                        accessibleEmpty[n - 1][j] = true;
                        queue.offer(new int[]{n - 1, j});
                    }
                }

                // BFS를 이용하여 외부와 연결된 빈 칸 영역을 구합니다.
                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    int x = curr[0], y = curr[1];

                    for (int[] d : directions) {
                        int nx = x + d[0], ny = y + d[1];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            if (grid[nx][ny] == '.' && !accessibleEmpty[nx][ny]) {
                                accessibleEmpty[nx][ny] = true;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }

                // 2. 요청한 종류의 컨테이너 중 접근 가능한 컨테이너만 제거합니다.
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (grid[i][j] == containerType) {
                            boolean isAccessible = false;
                            // 해당 컨테이너의 상하좌우 면을 확인합니다.
                            for (int[] d : directions) {
                                int nx = i + d[0], ny = j + d[1];
                                // 인접 칸이 격자 밖이면 외부와 바로 접촉하므로 접근 가능
                                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                                    isAccessible = true;
                                    break;
                                }
                                // 인접 칸이 빈 칸이면서 외부와 연결된 영역에 포함되면 접근 가능
                                if (grid[nx][ny] == '.' && accessibleEmpty[nx][ny]) {
                                    isAccessible = true;
                                    break;
                                }
                            }
                            if (isAccessible) {
                                grid[i][j] = '.';
                            }
                        }
                    }
                }
            }
        }

        // 모든 요청을 처리한 후 남아있는 컨테이너의 수를 계산합니다.
        int remaining = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != '.') {
                    remaining++;
                }
            }
        }

        return remaining;
    }
}