public class Solution {
    public long solution(int n) {
        // n이 1이나 2일 경우 바로 결과 반환 (기저 조건)
        if (n == 1) return 1;
        if (n == 2) return 2;

        int prev1 = 1; // dp[n-2]
        int prev2 = 2; // dp[n-1]
        int answer = 0;

        // 점화식 계산
        for (int i = 3; i <= n; i++) {
            answer = (prev1 + prev2) % 1234567; // 점화식 적용
            prev1 = prev2; // 이전 값 갱신
            prev2 = answer; // 이전 값 갱신
        }
        return answer;
    }
}
