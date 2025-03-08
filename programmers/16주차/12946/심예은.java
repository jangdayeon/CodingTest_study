import java.util.*;

class Solution {
    public int[][] solution(int n) {
        List<int[]> result = new ArrayList<>();
        hanoi(n, 1, 3, 2, result);
        return result.toArray(new int[result.size()][2]);
    }

    void hanoi(int num, int from, int to, int other, List<int[]> result) {
        if (num == 0) return;
        hanoi(num - 1, from, other, to, result);
        result.add(new int[]{from, to});
        hanoi(num - 1, other, to, from, result);
    }
}
