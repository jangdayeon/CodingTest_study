public class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int) (right - left + 1);
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            long index = left + i;
            result[i] = (int) (Math.max(index / n, index % n) + 1);
        }

        return result;
    }
}