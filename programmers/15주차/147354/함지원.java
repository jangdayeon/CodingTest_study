import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, Comparator
                .comparingInt((int[] d) -> d[col - 1])
                .thenComparing((d1, d2) -> Integer.compare(d2[0], d1[0])));

        for (int i = row_begin - 1; i < row_end; i++) {
            int sum = 0;

            for (int dataNum : data[i]) sum += dataNum % (i + 1);

            answer ^= sum;
        }

        return answer;
    }
}