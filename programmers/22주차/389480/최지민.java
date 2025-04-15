import java.util.*;

class Solution {
    int m = 0, n = 0;
    int minA = 121;
    
    Set<String> visited = new HashSet<>();
    
    private void thiefCase(int[][] info, int idx, int sumA, int sumB) {
        if(sumA >= n || sumB >= m) return;
        
        String key = idx + ":" + sumA + "," + sumB;
        if(visited.contains(key)) return;
        visited.add(key);
        
        if(idx == info.length) {
            minA = Math.min(minA, sumA);
            return;
        }
        
        thiefCase(info, idx + 1, sumA + info[idx][0], sumB);
        thiefCase(info, idx + 1, sumA, sumB + info[idx][1]);
        
    }
    
    public int solution(int[][] info, int n, int m) {
        this.n = n;
        this.m = m;
        
        thiefCase(info, 0, 0, 0);
        
        return (minA == 121) ? -1 : minA;
    }
}