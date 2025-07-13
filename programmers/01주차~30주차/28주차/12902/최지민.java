class Solution {
    public int solution(int n) {
        if(n % 2 != 0) return 0;
        
        long[] table = new long[n / 2 + 1];
        table[1] = 3;
        
        for(int i = 2; i <= n / 2; i++) {
            table[i] = (table[i - 1] * 3) + 2;
            
            for(int j = i - 2; j > 0; j--) {
                table[i] += (table[j] * 2);
            }
            
            table[i] %= 1_000_000_007;
        }
        
        return (int)table[n / 2];
    }
}