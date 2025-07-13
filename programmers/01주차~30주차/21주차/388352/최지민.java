import java.util.*;

class Solution {
    List<Integer> combiResult = new ArrayList<>();
    int[][] q;
    int[] ans;
    
    int answer = 0;
    
    private void search(int start, int idx, int n) {
        if(idx == 5) {
            boolean flag = true;
            Set<Integer> combiSet = new HashSet<>(combiResult);
            
            for(int i = 0; i < q.length; i++) {
                int cnt = 0;
                for(int j = 0; j < 5; j++) {
                    if(combiSet.contains(q[i][j])) cnt++;
                }
                
                if(cnt != ans[i]) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) answer++;
            
            return;
        }
        
        for(int i = start; i <= n; i++) {
            combiResult.add(i);
            search(i + 1, idx + 1, n);
            combiResult.remove(combiResult.size() - 1); 
        }
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        this.q = q;
        this.ans = ans;

        search(1, 0, n);
        
        return answer;
    }
}