import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }

        LinkedList<Integer> list = new LinkedList<>(map.values());
        Collections.sort(list);

        for (int i = list.size() - 1; i >= 0; i--) {
            if (k <= 0) {
                break;
            }
            k -= list.get(i);
            answer++;
        }
        return answer;
    }
}