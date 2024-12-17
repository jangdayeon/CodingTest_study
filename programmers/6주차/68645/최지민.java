import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] snail = new int[n][n];
        int[] xy = new int[]{-1, 0};
        
        int[][] direction = {{1, 0}, {0, 1}, {-1, -1}};
        int value = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i; j++) {
                xy[0] = xy[0] + direction[i % 3][0];
                xy[1] = xy[1] + direction[i % 3][1];
                snail[xy[0]][xy[1]] = ++value;
            }
        }
        
        return Arrays.stream(snail)
            .flatMapToInt(Arrays::stream)
            .filter(num -> num != 0)
            .toArray();
    }
}