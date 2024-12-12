class Solution {
    public int solution(int n) {
        int answer = 0;
        int limitNum = 1000000007;

        int prev1 = 1;
        int prev2 = 1;

        for (int i = 2; i <= n; i++) {
            answer = (prev1 + prev2) % limitNum;
            prev2 = prev1;
            prev1 = answer;
        }

        return answer;
    }
}