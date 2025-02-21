import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        int[] answer = new int[queries.length];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = i * columns + j + 1;
            }
        }

        for (int q = 0; q < queries.length; q++) {
            int x1 = queries[q][0] - 1, y1 = queries[q][1] - 1;
            int x2 = queries[q][2] - 1, y2 = queries[q][3] - 1;

            int temp = matrix[x1][y1];
            int minValue = temp;

            for (int up = x1; up < x2; up++) {
                matrix[up][y1] = matrix[up + 1][y1];
                minValue = Math.min(minValue, matrix[up][y1]);
            }

            for (int left = y1; left < y2; left++) {
                matrix[x2][left] = matrix[x2][left + 1];
                minValue = Math.min(minValue, matrix[x2][left]);
            }

            for (int down = x2; down > x1; down--) {
                matrix[down][y2] = matrix[down - 1][y2];
                minValue = Math.min(minValue, matrix[down][y2]);
            }

            for (int right = y2; right > y1 + 1; right--) {
                matrix[x1][right] = matrix[x1][right - 1];
                minValue = Math.min(minValue, matrix[x1][right]);
            }

            matrix[x1][y1 + 1] = temp;

            answer[q] = minValue;
        }

        return answer;
    }
}