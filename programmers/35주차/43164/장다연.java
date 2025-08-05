import java.util.*;

class Solution {
    private Map<String, List<String>> graph;
    private Map<String, Integer> visited;
    private List<String> ans = new ArrayList<>();
    private int ticketCount;

    public String[] solution(String[][] tickets) {
        graph = new HashMap<>();
        visited = new HashMap<>();
        ticketCount = tickets.length;

        // 그래프 및 방문 기록 구성
        for (String[] t : tickets) {
            graph.computeIfAbsent(t[0], k -> new ArrayList<>()).add(t[1]);
            String key = t[0] + " " + t[1];
            visited.put(key, visited.getOrDefault(key, 0) + 1);
        }

        // 사전순 정렬
        for (String key : graph.keySet()) {
            Collections.sort(graph.get(key));
        }

        ans.add("ICN");
        dfs("ICN");
        
        return ans.toArray(new String[0]);
    }

    private boolean dfs(String now) {
        // 모든 티켓을 다 쓴 경우 = 성공
        if (ans.size() == ticketCount + 1) {
            return true;
        }

        List<String> q = graph.getOrDefault(now, new ArrayList<>());

        for (int i = 0; i < q.size(); i++) {
            String next = q.get(i);
            String key = now + " " + next;

            if (visited.getOrDefault(key, 0) > 0) {
                // 사용
                visited.put(key, visited.get(key) - 1);
                ans.add(next);

                if (dfs(next)) return true; // 성공 시 바로 종료

                // 실패하면 복구
                visited.put(key, visited.get(key) + 1);
                ans.remove(ans.size() - 1);
            }
        }

        return false; // 모든 경로 실패
    }
}
