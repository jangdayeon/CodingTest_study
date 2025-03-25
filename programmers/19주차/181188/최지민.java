import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        
        Arrays.sort(targets, (a, b) -> (a[1] == b[1]) ? a[0] - b[0] : a[1] - b[1]);
        
        double endPoint = targets[0][1] - 0.01;
        for(int i = 1; i < targets.length; i++) {
            if(endPoint < targets[i][0] || endPoint > targets[i][1]) {
                endPoint = targets[i][1] - 0.01;
                answer++;
            }
        }
        
        return answer;
    }
}