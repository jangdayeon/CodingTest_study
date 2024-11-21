import java.util.*;

public class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        boolean[][] marked;
        int answer = 0;

        while (true) {
            marked = new boolean[m][n];
            boolean found = false;

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] != ' ' &&
                            map[i][j] == map[i + 1][j] &&
                            map[i][j] == map[i][j + 1] &&
                            map[i][j] == map[i + 1][j + 1]) {
                        marked[i][j] = true;
                        marked[i + 1][j] = true;
                        marked[i][j + 1] = true;
                        marked[i + 1][j + 1] = true;
                        found = true;
                    }
                }
            }

            if (!found) break;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (marked[i][j]) {
                        map[i][j] = ' ';
                        answer++;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                int emptyRow = m - 1;

                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != ' ') {
                        char temp = map[i][j];
                        map[i][j] = ' ';
                        map[emptyRow][j] = temp;
                        emptyRow--;
                    }
                }
            }
        }
        return answer;
    }
}
