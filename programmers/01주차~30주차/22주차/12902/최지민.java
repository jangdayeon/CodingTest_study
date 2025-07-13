class Solution {
    public int solution(int n) {
        long[] table = new long[n + 1];
        
        table[2] = 3;
        
        for(int i = 4; i < n + 1; i++) {
            if(i % 2 != 0) continue;
            
            table[i] = (table[i - 2] * 3) + 2;
            for(int j = i - 4; j > 0; j -= 2) {
                table[i] += (table[j] * 2);
            }
            
            table[i] %= 1_000_000_007;
        }
        
        return (int)table[n];
    }
}