import java.util.*;

class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        List<Integer> groupCnt = new ArrayList<>();
        
        for(int i = 0; i < cards.length; i++) {
            int cardNum = cards[i] - 1;
            int cnt = 0;
            
            while(!visited[cardNum]) {
                visited[cardNum] = true;
                cardNum = cards[cardNum] - 1;
                cnt++;
            }
            
            groupCnt.add(cnt);
        }
        
        Collections.sort(groupCnt);
        
        return groupCnt.get(groupCnt.size() - 1) * groupCnt.get(groupCnt.size() - 2);
    }
}