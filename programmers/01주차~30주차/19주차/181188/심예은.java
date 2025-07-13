import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int lastIntercept = -1;

        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];

            if (lastIntercept <= start) {
                lastIntercept = end;
                count++;
            }
        }
        return count;
    }
}
