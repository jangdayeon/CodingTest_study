import java.util.*;

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        // 모든 info에서 조합 만들기
        for (String i : info) {
            String[] arr = i.split(" ");
            makeComb(arr, "", 0);
        }

        // 이진 탐색을 위한 정렬
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        int[] result = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            // 쿼리 문자열 정리
            String[] parts = query[i].replaceAll(" and ", " ").split(" ");
            String key = parts[0] + parts[1] + parts[2] + parts[3];
            int target = Integer.parseInt(parts[4]);

            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            result[i] = countGreaterOrEqual(list, target);
        }

        return result;
    }

    // 조합 만들기: 조건 4개에서 '-' 포함한 모든 조합 생성
    void makeComb(String[] arr, String str, int depth) {
        if (depth == 4) {
            map.computeIfAbsent(str, k -> new ArrayList<>()).add(Integer.parseInt(arr[4]));
            return;
        }

        makeComb(arr, str + arr[depth], depth + 1);
        makeComb(arr, str + "-", depth + 1);
    }

    // 이진 탐색으로 target 이상인 개수 세기
    int countGreaterOrEqual(List<Integer> list, int target) {
        int left = 0, right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid;
        }

        return list.size() - left;
    }
}