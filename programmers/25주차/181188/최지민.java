import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        
        double last = targets[0][1] - 0.01;
        for(int i = 0; i < targets.length; i++) {
            if(last > targets[i][0] && last < targets[i][1]) continue;
                
            last = targets[i][1] - 0.01;
            answer++;
        }
        
        return answer;
    }
}