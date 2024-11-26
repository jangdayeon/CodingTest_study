import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] table = new int[y + 1];
        
        Arrays.fill(table, y + 1);
        table[x] = 0;
        
        for(int i = x; i <= y; i++) {
            if(i + n <= y) {
                table[i + n] = Math.min(table[i] + 1, table[i + n]);
            }
            if(i * 2 <= y) {
                table[i * 2] = Math.min(table[i] + 1, table[i * 2]);
            }
            if(i * 3 <= y) {
                table[i * 3] = Math.min(table[i] + 1, table[i * 3]);
            }
        }
        
        return table[y] == y + 1 ? -1 : table[y];
    }
}