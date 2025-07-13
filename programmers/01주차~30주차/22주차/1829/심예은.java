class Solution {
    int[] dx = {-1, 1, 0, 0}; // 상하좌우
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited;
    int m, n;
    int[][] picture;

    public int[] solution(int m, int n, int[][] picture) {
        this.m = m;
        this.n = n;
        this.picture = picture;
        visited = new boolean[m][n];

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    numberOfArea++;
                    int areaSize = dfs(i, j, picture[i][j]);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, areaSize);
                }
            }
        }

        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    private int dfs(int x, int y, int color) {
        visited[x][y] = true;
        int size = 1;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if (!visited[nx][ny] && picture[nx][ny] == color) {
                    size += dfs(nx, ny, color);
                }
            }
        }

        return size;
    }
}