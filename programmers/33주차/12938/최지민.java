import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int num = s / n, rest = s % n;
        
        if(num == 0) return new int[]{-1};
        
        int[] result = new int[n];
        Arrays.fill(result, num);
        
        int i = 0;
        while(rest > 0) {
            if(i >= n) {
                i = 0;
                continue;
            }
            
            result[i]++;
            rest--;
            
            i++;
        }
        
        Arrays.sort(result);
        
        return result;
    }
}