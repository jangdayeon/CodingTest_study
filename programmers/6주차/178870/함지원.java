import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int lt = 0, rt = 0;
        int sum = 0;
        int[] answer = new int[2];
        int minLength = Integer.MAX_VALUE;

        while (rt < sequence.length) {
            sum += sequence[rt]; // rt를 증가시켜 구간 합에 더함

            // sum이 k보다 크면 lt를 증가시켜 구간 합을 줄임
            while (sum > k && lt <= rt) {
                sum -= sequence[lt];
                lt++;
            }

            // sum이 k와 같으면 구간을 기록
            if (sum == k) {
                int length = rt - lt; // 길이 계산
                if (length < minLength) {
                    minLength = length;
                    answer[0] = lt; // 시작 인덱스
                    answer[1] = rt; // 끝 인덱스
                }
            }
            rt++;
        }
        return answer;
    }
}