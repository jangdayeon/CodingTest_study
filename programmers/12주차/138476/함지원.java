import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> tangerines = new HashMap<>();

        for (int t : tangerine) tangerines.put(t, tangerines.getOrDefault(t, 0) + 1);

        List<Integer> list = new ArrayList<>(tangerines.values());
        Collections.sort(list, Comparator.reverseOrder());


        for (Integer goods : list) {
            k -= goods;
            answer++;
            if (k <= 0) break;
        }

        return answer;
    }
}