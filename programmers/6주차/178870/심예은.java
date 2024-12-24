class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0, right = 0, sum = 0;
        int[] answer = new int[2];
        int minLength = Integer.MAX_VALUE;

        for (right = 0; right < sequence.length; right++) {
            sum += sequence[right]; // 구간 합에 더함

            // sum이 k를 초과하면 left를 증가시키며 구간 축소
            while (sum > k) {
                sum -= sequence[left];
                left++;
            }

            // sum이 k와 같으면 최소 길이를 갱신
            if (sum == k) {
                int length = right - left + 1; // 구간의 실제 길이
                if (length < minLength) {
                    minLength = length;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }

        return answer;
    }
}
