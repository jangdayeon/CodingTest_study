class Solution {
    public int solution(int n) {
        if(n%2==1) return 0; //홀수 예외 처리
        int answer = 0;
        long[] dp = new long[n/2+1]; // 짝수인 값만 저장하려고
        //n == 2 -> dp[2/2]
        dp[1] = 3;
        dp[2] = 11;
        //아래와 같은 케이스를 위한 변수
        // |===|    -----
        // ----- or |===|
        long sum = 3*2;
        for(int i=3; i<n/2+1; i++){
            dp[i] = (sum + dp[i-1] * 3 + 2) % 1_000_000_007;
            sum += (dp[i-1] * 2) % 1_000_000_007;
        }
        return (int) dp[n/2];
    }
}