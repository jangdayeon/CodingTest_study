//정렬 후 현재 값이 타깃의 시작점보다 같거나 적으면, 새로운 미사일을 추가하고, 현재 값 갱신

import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer =0;
        Arrays.sort(targets, (o1,o2)->o1[1]-o2[1]);
        int before = 0;
        for(int i=0;i<targets.length;i++){
            if(before <= targets[i][0]){
                before = targets[i][1];
                answer++;
            }
        }
        return answer;
    }
}