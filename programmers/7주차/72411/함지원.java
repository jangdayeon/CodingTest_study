import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] courses) {
        List<String> answer = new LinkedList<>();

        for (int course : courses) {
            Map<String, Integer> orderMap = new HashMap<>();

            for (String order : orders) {
                char[] orderCh = order.toCharArray();
                Arrays.sort(orderCh);
                find(orderCh, course, 0, "", orderMap);
            }

            int maxCnt = 2;
            List<String> candidates = new LinkedList<>();
            for (Map.Entry<String, Integer> entry : orderMap.entrySet()) {
                if (entry.getValue() > maxCnt) {
                    maxCnt = entry.getValue();
                    candidates.clear();
                    candidates.add(entry.getKey());
                } else if (entry.getValue() == maxCnt) {
                    candidates.add(entry.getKey());
                }
            }
            answer.addAll(candidates);
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    private void find(char[] orderCh, int length, int start, String current, Map<String, Integer> combinationCnt) {
        if (current.length() == length) {
            combinationCnt.put(current, combinationCnt.getOrDefault(current, 0) + 1);
            return;
        }
        for (int i = start; i < orderCh.length; i++) {
            find(orderCh, length, i + 1, current + orderCh[i], combinationCnt);
        }
    }
}