import java.util.*;

class Solution {
    int[] result = new int[5];
    int[][] q;
    int[] ans;
    
    int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        this.q = q;
        this.ans = ans;
        
        code(0, 0, n);
        
        return answer;
    }
    
    private void code(int start, int depth, int n) {
        if(depth == 5) {
            if(check()) answer++;
            return;
        }
        
        for(int i = start; i < n; i++) {
            result[depth] = i + 1;
            code(i + 1, depth + 1, n);
        }
    }
    
    private boolean check() {
        for(int i = 0; i < q.length; i++) {
            int cnt = 0;
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    if(result[j] == q[i][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            
            if(cnt != ans[i]) return false;
        }
        
        return true;
    }
}