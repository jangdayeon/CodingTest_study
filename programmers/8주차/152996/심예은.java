import java.util.Arrays;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        Arrays.sort(weights);
        for (int i = 0; i < weights.length - 1; ++i) {
            int weight = weights[i];
            for (int j = i + 1; j < weights.length; ++j) {
                int pairWeight = weights[j];
                if (weight == pairWeight) {
                    ++answer;
                    continue;
                }

                if (weight * 4 == pairWeight * 2 || weight * 4 == pairWeight * 3 || weight * 3 == pairWeight * 2) {
                    ++answer;
                    continue;
                }
            }
        }

        return answer;
    }
}