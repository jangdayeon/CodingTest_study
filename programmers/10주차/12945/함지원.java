class Solution {
    public int solution(int n) {
        int answer = 0, prev1 = 1, prev2 = 1;

        for (int i = 3; i <= n; i++) {
            answer = (prev1 + prev2) % 1234567;
            prev1 = prev2;
            prev2 = answer;
        }

        return answer % 1234567;
    }
}