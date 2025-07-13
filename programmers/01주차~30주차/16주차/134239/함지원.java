import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> collatzSequence = new ArrayList<>();
        collatzSequence.add(k);

        while (k != 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            collatzSequence.add(k);
        }

        int n = collatzSequence.size() - 1;
        double[] areas = new double[n];

        for (int i = 0; i < n; i++) {
            int y1 = collatzSequence.get(i);
            int y2 = collatzSequence.get(i + 1);
            areas[i] = (y1 + y2) / 2.0;
        }

        double[] prefixSum = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + areas[i];
        }

        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = ranges[i][1];
            int end = n + b;

            if (a > end) {
                answer[i] = -1.0;
            } else {
                answer[i] = prefixSum[end] - prefixSum[a];
            }
        }

        return answer;
    }
}