//겹치는 구간 구하기(요격 시스템과 비슷)
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, Comparator.comparingInt(a->a[1]));
        int before = -30001;
        for(int i=0; i<routes.length; i++){
            if(routes[i][0] > before){
                before = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}