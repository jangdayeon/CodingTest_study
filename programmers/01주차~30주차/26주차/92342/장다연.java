import java.util.*;

class Solution {
    private int[] tempResult;
    private int max = 0;
    private int[] answer = {-1};

    public int[] solution(int n, int[] info) {
        tempResult = new int[info.length];
        permutation(0, n, info);
        return answer;
    }

    private void permutation(int r, int rest, int[] info) {
        if (r == info.length || rest == 0) {
            if (rest > 0) tempResult[10] += rest;
            setMax(info);
            if (rest > 0) tempResult[10] -= rest;
            return;
        }

        for (int j = 0; j <= rest; j++) {
            tempResult[r] = j;
            permutation(r + 1, rest - j, info);
            tempResult[r] = 0;
        }
    }

    private void setMax(int[] info) {
        int lion = 0;
        int apeach = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] == 0 && tempResult[i] == 0) continue;

            if (tempResult[i] > info[i]) lion += 10 - i;
            else apeach += 10 - i;
        }

        int diff = lion - apeach;
        if (diff <= 0) return;

        if (diff > max) {
            max = diff;
            answer = Arrays.copyOf(tempResult, tempResult.length);
        } else if (diff == max) {
            for (int i = info.length - 1; i >= 0; i--) {
                if (tempResult[i] > answer[i]) {
                    answer = Arrays.copyOf(tempResult, tempResult.length);
                    break;
                } else if (tempResult[i] < answer[i]) {
                    break;
                }
            }
        }
    }
}
