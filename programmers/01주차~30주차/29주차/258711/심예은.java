import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        Set<Integer> allNodes = new HashSet<>();

        // 간선 정보를 바탕으로 진입차수, 진출차수 계산
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];

            out.put(from, out.getOrDefault(from, 0) + 1);
            in.put(to, in.getOrDefault(to, 0) + 1);

            allNodes.add(from);
            allNodes.add(to);
        }

        // 생성된 정점: 진입차수 0 && 진출차수 2 이상
        int created = -1;
        for (int node : allNodes) {
            int inCount = in.getOrDefault(node, 0);
            int outCount = out.getOrDefault(node, 0);
            if (inCount == 0 && outCount >= 2) {
                created = node;
                break;
            }
        }

        int totalGraphs = out.get(created); // 생성된 정점이 연결한 그래프 수
        int donuts = 0, sticks = 0, eights = 0;

        for (int node : allNodes) {
            if (node == created) continue;

            int inCount = in.getOrDefault(node, 0);
            int outCount = out.getOrDefault(node, 0);

            // 막대 모양 그래프는 말단 노드(out = 0)
            if (outCount == 0) {
                sticks++;
            }
            // 8자 모양 그래프는 교차점 노드(out ≥ 2)
            else if (outCount >= 2) {
                eights++;
            }
        }

        // 나머지는 도넛
        donuts = totalGraphs - sticks - eights;

        return new int[]{created, donuts, sticks, eights};
    }
}