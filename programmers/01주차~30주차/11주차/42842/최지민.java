import java.util.*;

class Solution {
    List<Integer> divisorArr = new ArrayList<>();
    
    public int[] solution(int brown, int yellow) {
        getDivisor(yellow);
        
        for(int d : divisorArr) {
            int w = yellow / d;
            if(((w * 2) + (d * 2) + 4) == brown) return new int[]{w + 2, d + 2};
        }
        
        return new int[]{0, 0};
    }
    
    private void getDivisor(int n) {
        for(int i = 1; i < Math.sqrt(n) + 1; i++) {
            if(n % i == 0) divisorArr.add(i);
        }
    }
}