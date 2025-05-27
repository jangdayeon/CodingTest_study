class Solution {
    private final int[] dr = {-1, 1, 0, 0}; // 상하좌우 row 이동
    private final int[] dc = {0, 0, -1, 1}; // 상하좌우 col 이동

    public int[] solution(int m, int n, int[][] pic) {
        boolean[][] visit = new boolean[m][n];
        int count = 0;
        int max = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (!visit[r][c] && pic[r][c] != 0) {
                    count++;
                    int size = dfs(r, c, pic[r][c], pic, visit, m, n);
                    max = Math.max(max, size);
                }
            }
        }

        return new int[]{count, max};
    }

    private int dfs(int r, int c, int color, int[][] pic, boolean[][] visit, int m, int n) {
        visit[r][c] = true;
        int size = 1;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                if (!visit[nr][nc] && pic[nr][nc] == color) {
                    size += dfs(nr, nc, color, pic, visit, m, n);
                }
            }
        }

        return size;
    }
}