import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int before = 0;
        int sIdx = 0;
        for(int i=1; i<=n; i++){
            // System.out.println(i);
            if(before < i) {
                int start = sIdx== stations.length ? -1 : stations[sIdx]-w;
                int end =  sIdx== stations.length ? -1 : stations[sIdx]+w;
                if(sIdx== stations.length || start > before + 1) { //존재한 기지국으로 커버 안될 때
                    answer++;
                    before = before + 1 + w*2;
                } else {
                    before = end;
                    sIdx++;
                }
            }
            i = before; //시간복잡도 줄이기 위해
        }
        return answer;
    }
}