import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, Comparator.comparingInt(a->a[1]));
        
        int locate = -1;
        for(int i=0; i<targets.length; i++){
            if(locate >= targets[i][0]) continue;
            locate = targets[i][1]-1;
            answer += 1;
        }
        return answer;
    }
}