import java.util.*;

class Solution {
    int[] result;
    int answer = 0;
    
    public int solution(int n) {
        result = new int[n];
        queen(0, n, new boolean[n]);
        
        return answer;
    }
    
    private void queen(int depth, int n, boolean[] visited) {
        if(depth == n) {
            answer++;
            return;
        }
        
        for(int i = 0; i < n; i++) {
            result[depth] = i;
            if(check(depth)) {
                queen(depth + 1, n, visited);
            }
        }
    }
    
    private boolean check(int depth) {
        for(int i = 0; i < depth; i++) {
            if(result[i] == result[depth]) return false;
            if(Math.abs(i - depth) == Math.abs(result[i] - result[depth])) return false;
        }
        
        return true;
    }
}