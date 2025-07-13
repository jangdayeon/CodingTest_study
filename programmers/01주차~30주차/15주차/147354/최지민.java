import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (a, b) -> {
            return (a[col - 1] == b[col - 1]) ? Integer.compare(b[0], a[0]) : Integer.compare(a[col - 1], b[col - 1]);
        });

        for(int i = row_begin; i <= row_end; i++) {
            int sumResult = 0;
            for(int d : data[i - 1]) {
                sumResult += (d % i);
            }
            
            answer ^= sumResult;
        }
        
        return answer;
    }
}