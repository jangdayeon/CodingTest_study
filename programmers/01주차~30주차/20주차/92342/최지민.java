import java.util.*;

class Solution {
    int result = -1;
    int[] maxScore = {-1};
    
    private void dfs(int idx, int arrowLeft, int[] ryan, int[] info) {
        if(idx == 11 || arrowLeft == 0) {
            int[] copyArr = Arrays.copyOf(ryan, 11);
            if(arrowLeft > 0) copyArr[10] += arrowLeft;
            
            int ryanScore = 0, apeachScore = 0;
            
            for(int i = 0; i < 11; i++) {
                if(copyArr[i] == 0 && info[i] == 0) continue;
                
                if(copyArr[i] > info[i]) ryanScore += (10 - i);
                else apeachScore += (10 - i);
            }
            
            int scoreGap = ryanScore - apeachScore;
            if(scoreGap <= 0) return;
            
            if(result < scoreGap) {
                result = scoreGap;
                maxScore = copyArr;
            } else if(result == scoreGap) {
                for(int i = 10; i > -1; i--) {
                    if(copyArr[i] > maxScore[i]) {
                        maxScore = copyArr;
                        break;
                    } else if(maxScore[i] > copyArr[i]) break;
                }
            }
            
            return;
        }
        
        if(arrowLeft > info[idx]) {
            ryan[idx] = info[idx] + 1;
            dfs(idx + 1, arrowLeft - ryan[idx], ryan, info);
            ryan[idx] = 0;
        }
        
        dfs(idx + 1, arrowLeft, ryan, info);
    }
    
    public int[] solution(int n, int[] info) {
        dfs(0, n, new int[11], info);
        
        return maxScore;
    }
}