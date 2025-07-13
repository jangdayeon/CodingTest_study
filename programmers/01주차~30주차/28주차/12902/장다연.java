class Solution {
    private int MOD = 1_000_000_007;
    public int solution(int n) {
        long[] dp = new long[n+1];
        dp[2] = 3;
        for(int i=4; i<n+1; i+=2){
            dp[i] = (dp[i-2] * 3 + 2) % MOD;
            for(int j=i-4; j>0; j-=2){
                dp[i] += ((dp[j] * 2)) % MOD;
            }
            dp[i] %= MOD;
        }
        return (int)dp[n];
    }
}