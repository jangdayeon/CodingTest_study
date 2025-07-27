import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemKinds = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> gemsPart = new HashMap<>();

        int left = 0, right = 0;
        int minLen = gems.length + 1;
        int[] answer = new int[2];

        gemsPart.put(gems[0], 1);

        while (left <= right && right < gems.length) {
            if (gemsPart.size() == gemKinds.size()) {
                // 최소 길이 갱신
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    answer[0] = left + 1;  // 1-based index
                    answer[1] = right + 1;
                }

                // 왼쪽 포인터 이동
                gemsPart.put(gems[left], gemsPart.get(gems[left]) - 1);
                if (gemsPart.get(gems[left]) == 0) {
                    gemsPart.remove(gems[left]);
                }
                left++;
            } else {
                // 오른쪽 포인터 이동
                right++;
                if (right < gems.length) {
                    gemsPart.put(gems[right], gemsPart.getOrDefault(gems[right], 0) + 1);
                }
            }
        }

        return answer;
    }
}
