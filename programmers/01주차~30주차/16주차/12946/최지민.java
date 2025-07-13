import java.util.*;

class Solution {
    List<int[]> result = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);

        return result.toArray(new int[0][]);
    }
    
    private void hanoi(int n, int from, int tmp, int to) {
        if(n == 1) {
            result.add(new int[]{from, to});
            return;
        }
        
        hanoi(n - 1, from, to, tmp);
        result.add(new int[]{from, to});
        hanoi(n - 1, tmp, from, to);
    }
}