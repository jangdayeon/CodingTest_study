import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0, idx = B.length - 1;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int x : A) {
            answer += x * B[idx];
            idx--;
        }

        return answer;
    }
}