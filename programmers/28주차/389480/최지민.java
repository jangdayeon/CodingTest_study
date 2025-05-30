import java.util.*;

class Solution {
    int minA = 121;
    HashSet<String> visited = new HashSet<>();
    
    public int solution(int[][] info, int n, int m) {
        steal(0, 0, 0, n, m, info);
        
        return (minA == 121) ? -1 : minA;
    }
    
    private void steal(int depth, int at, int bt, int n, int m, int[][] info) {
        if(at >= n || bt >= m) return;
        
        String key = "depth:" + depth + ",a:" + at + ",b:" + bt;
        if(visited.contains(key)) return;
        visited.add(key);
        
        if(depth == info.length) {
            minA = Math.min(minA, at);
            return;
        }

        steal(depth + 1, at + info[depth][0], bt, n, m, info);
        steal(depth + 1, at, bt + info[depth][1], n, m, info);
    }
}