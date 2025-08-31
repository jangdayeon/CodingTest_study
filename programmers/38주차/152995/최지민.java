import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        int[] wh = new int[]{scores[0][0], scores[0][1]};
        
        Arrays.sort(scores, (a, b) -> (a[0] != b[0]) ? b[0] - a[0] : a[1] - b[1]);
        
        int maxPr = -1, whSum = wh[0] + wh[1];
        for(int[] s : scores) {
            if(s[1] < maxPr) {
                if(s[0] == wh[0] && s[1] == wh[1]) return -1;
                continue;
            } else {
                maxPr = s[1];
            }
            
            if(whSum < s[0] + s[1]) answer++;
        }
        
        return answer;
    }
}