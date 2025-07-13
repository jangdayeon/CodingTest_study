import java.util.*;

class Solution {
    int[] answer = {-1};
    int maxGap = -1;
    
    public int[] solution(int n, int[] info) {
        dfs(new int[11], info, 0, n);
        
        return answer;
    }
    
    private void dfs(int[] ryan, int[] apeach, int idx, int remain) {
        if(idx == 11) {
            int[] copyRyan = Arrays.copyOf(ryan, 11);
            if(remain > 0) copyRyan[10] += remain;
            
            int aScore = 0, lScore = 0;
            for(int i = 0; i < 11; i++) {
                if(apeach[i] == 0 && copyRyan[i] == 0) continue;
                
                if(copyRyan[i] > apeach[i]) lScore += (10 - i);
                else aScore += (10 - i);
            }
            
            int scoreGap = lScore - aScore;
            if(scoreGap <= 0) return;
            
            if(maxGap < scoreGap) {
                maxGap = scoreGap;
                answer = copyRyan;
            } else if(maxGap == scoreGap) {
                for(int i = 10; i > -1; i--) {
                    if(copyRyan[i] > answer[i]) {
                        answer = copyRyan;
                        break;
                    } else if(answer[i] > copyRyan[i]) break;
                }
            }
            
            return;
        }
        
        int need = apeach[idx] + 1;
        if(need <= remain) {
            ryan[idx] = need;
            dfs(ryan, apeach, idx + 1, remain - need);
            ryan[idx] = 0;
        }
        
        dfs(ryan, apeach, idx + 1, remain);
    }
}