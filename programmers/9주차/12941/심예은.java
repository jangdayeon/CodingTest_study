import java.util.*;

public class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        // 배열 A와 B를 각각 오름차순으로 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        // 두 배열에서 각각 최소값(A)와 최대값(B)을 선택하여 곱한 값을 누적
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - 1 - i]; // B는 내림차순으로 선택
        }

        return answer;
    }
}
