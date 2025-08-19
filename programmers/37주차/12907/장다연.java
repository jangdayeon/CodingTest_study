import java.util.*;

class Solution {
    final int MOD = 1_000_000_007;
    public int solution(int n, int[] money) {
        Arrays.sort(money);
        int[] knapsack = new int[n+1];
        knapsack[0] = 1;
        for(int m : money){
            for(int i=m; i<=n; i++){
                knapsack[i] = (knapsack[i] + knapsack[i-m]) % MOD;
            }
        }
        return knapsack[n];
    }
}