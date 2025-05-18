import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int rows = storage.length;
        int cols = storage[0].length();
        int answer = rows * cols;

        // 원본 stor 배열 + 테두리 추가한 stor 배열 생성
        char[][] stor = new char[rows + 2][cols + 2];
        boolean[][] visited = new boolean[rows + 2][cols + 2];

        // stor 배열 초기화 (테두리는 '-'로, 내부는 storage 값 복사)
        for (int i = 0; i < rows + 2; i++) {
            Arrays.fill(stor[i], '-');
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                stor[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        // 테두리는 방문 처리(true)로 설정 (외부 공간)
        for (int i = 0; i < rows + 2; i++) {
            visited[i][0] = true;
            visited[i][cols + 1] = true;
        }
        for (int j = 0; j < cols + 2; j++) {
            visited[0][j] = true;
            visited[rows + 1][j] = true;
        }

        for (String req : requests) {
            char target = req.charAt(0);
            if (req.length() == 1) {
                answer -= repeatOne(target, visited, stor);
            } else {
                answer -= repeatTwo(target, visited, stor);
            }
        }

        return answer;
    }

    // 요청 글자가 2개 이상일 때 (repeatTwo)
    private int repeatTwo(char target, boolean[][] visited, char[][] stor) {
        int count = 0;
        int rows = stor.length;
        int cols = stor[0].length;
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (stor[i][j] == target && !visited[i][j]) {
                    visited[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    // 요청 글자가 1개일 때 (repeatOne) - BFS를 통해 외부에서 접근 가능한 곳만 방문
    private int repeatOne(char target, boolean[][] visited, char[][] stor) {
        int count = 0;
        int rows = stor.length;
        int cols = stor[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visitedBFS = new boolean[rows][cols];
        List<int[]> memory = new ArrayList<>();
        
        queue.offer(new int[]{0, 0});
        visitedBFS[0][0] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols) {
                    if (!visitedBFS[nx][ny]) {
                        // 방문하지 않았고, 타깃일 경우
                        if (stor[nx][ny] == target && !visited[nx][ny]) {
                            memory.add(new int[]{nx, ny});
                            visitedBFS[nx][ny] = true;
                        } else if (visited[nx][ny]) { //방문했던 곳일 경우
                            queue.offer(new int[]{nx, ny});
                            visitedBFS[nx][ny] = true;
                        }
                    }
                }
            }
        }
        for(int[] m : memory){
            visited[m[0]][m[1]] = true;
            count++;
        }
        return count;
    }
}
