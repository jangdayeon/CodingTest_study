import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> map = new HashMap<>();
        
        for (String inf : info) {
            String[] parts = inf.split(" ");
            String[] lang = {"-", parts[0]};
            String[] job = {"-", parts[1]};
            String[] career = {"-", parts[2]};
            String[] food = {"-", parts[3]};
            int score = Integer.parseInt(parts[4]);
            
            for (String l : lang) {
                for (String j : job) {
                    for (String c : career) {
                        for (String f : food) {
                            String key = l + " " + j + " " + c + " " + f;
                            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
                        }
                    }
                }
            }
        }

        // 점수 오름차순 정렬
        for (List<Integer> scores : map.values()) {
            scores.sort(null);
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] qAndS = preprocessingQuery(query[i]);
            List<Integer> scores = map.getOrDefault(qAndS[0], new ArrayList<>());
            answer[i] = binarySearch(scores, Integer.parseInt(qAndS[1]));
        }

        return answer;
    }

    // "java and backend and junior and pizza 150" → ["java backend junior pizza", "150"]
    private String[] preprocessingQuery(String q) {
        String[] step = q.replace(" and", "").split(" ");
        String query = step[0] + " " + step[1] + " " + step[2] + " " + step[3];
        String score = step[4];
        return new String[]{query, score};
    }

    // 기준 점수 이상인 사람 수를 찾는 이진 탐색
    private int binarySearch(List<Integer> scores, int standard) {
        int start = 0;
        int end = scores.size();

        while (start < end) {
            int mid = (start + end) / 2;
            if (scores.get(mid) < standard) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return scores.size() - start;
    }
}
