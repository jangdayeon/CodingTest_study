import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> tangerines = new HashMap<>();

        for (int t : tangerine) tangerines.put(t, tangerines.getOrDefault(t, 0) + 1);

        LinkedList<Integer> list = new LinkedList<>(tangerines.values());
        Collections.sort(list.reversed());

        for (Integer key : list) {
            k -= tangerines.get(key);
            answer++;
            if (k <= 0) break;
        }

        return answer;
    }
}