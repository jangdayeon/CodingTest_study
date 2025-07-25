import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        Map<Integer, List<Integer>> BannedUserId = new HashMap<>();
        for (int i = 0; i < banned_id.length; i++) {
            List<Integer> userIds = new ArrayList<>();
            char[] banned = banned_id[i].toCharArray();

            for (int j = 0; j < user_id.length; j++) {
                char[] user = user_id[j].toCharArray();
                if (banned.length != user.length) continue;
                boolean toggle = false;
                for (int k = 0; k < user.length; k++) {
                    if (banned[k] == '*') continue;
                    if (banned[k] != user[k]) {
                        toggle = true;
                        break;
                    }
                }
                if (!toggle) userIds.add(j);
            }
            BannedUserId.put(i, userIds);
        }

        return bfs(BannedUserId, user_id.length);
    }

    private int bfs(Map<Integer, List<Integer>> map, int userSize) {
        Set<Set<Integer>> rst = new HashSet<>();
        recursive(0, new boolean[userSize], new HashSet<>(), map, rst);
        return rst.size();
    }

    private void recursive(int n, boolean[] visited, Set<Integer> s,
                           Map<Integer, List<Integer>> map, Set<Set<Integer>> rst) {
        if (n == map.size()) {
            rst.add(new HashSet<>(s)); // ✅ 복사해서 넣기
            return;
        }
        for (int now : map.get(n)) {
            if (!visited[now]) {
                visited[now] = true;
                s.add(now);
                recursive(n + 1, visited, s, map, rst);
                visited[now] = false;
                s.remove(now);
            }
        }
    }
}
