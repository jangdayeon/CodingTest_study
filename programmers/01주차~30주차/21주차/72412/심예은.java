import java.util.*;

class Solution {
    static Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        for (String i : info) {
            String[] parts = i.split(" ");
            dfs(parts, "", 0);
        }

        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String q = query[i].replaceAll(" and ", " ");
            String[] parts = q.split(" ");
            String key = parts[0] + parts[1] + parts[2] + parts[3];
            int score = Integer.parseInt(parts[4]);

            if (!map.containsKey(key)) {
                answer[i] = 0;
                continue;
            }

            List<Integer> list = map.get(key);
            int idx = binarySearch(list, score);
            answer[i] = list.size() - idx;
        }

        return answer;
    }

    private void dfs(String[] parts, String str, int depth) {
        if (depth == 4) {
            map.computeIfAbsent(str, k -> new ArrayList<>()).add(Integer.parseInt(parts[4]));
            return;
        }

        dfs(parts, str + parts[depth], depth + 1);
        dfs(parts, str + "-", depth + 1);
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
