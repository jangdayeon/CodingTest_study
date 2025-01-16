public class Solution {
    public int solution(int n) {
        int count = 0;

        // 연속된 자연수의 시작 숫자를 i로 설정
        for (int i = 1; i <= n; i++) {
            int sum = 0;

            // 연속된 숫자를 더해가며 합이 n인지 확인
            for (int j = i; j <= n; j++) {
                sum += j;

                if (sum == n) {
                    count++; // n에 도달하면 경우의 수 증가
                    break;
                } else if (sum > n) {
                    break; // 합이 n을 초과하면 더 이상 확인하지 않음
                }
            }
        }
        return count;
    }
}