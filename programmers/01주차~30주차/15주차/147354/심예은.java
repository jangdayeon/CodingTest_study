import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {

        // col 번째 컬럼 오름차순, 기본키(첫 번째 컬럼) 내림차순
        Arrays.sort(data, (a, b) -> a[col - 1] == b[col - 1] ? b[0] - a[0] : a[col - 1] - b[col - 1]);

        int result = 0;

        for (int i = row_begin; i <= row_end; i++) {
            int sum = 0;
            for (int value : data[i - 1]) {  // i 번째 행 → 실제 인덱스는 i-1
                sum += value % i;
            }
            result ^= sum;  // XOR 연산
        }
        return result;
    }
}