import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        Set<Integer> nodes = new HashSet<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            outDegree.put(from, outDegree.getOrDefault(from, 0) + 1);
            inDegree.put(to, inDegree.getOrDefault(to, 0) + 1);

            nodes.add(from);
            nodes.add(to);
        }

        int createdNode = 0;
        for (int node : nodes) {
            int out = outDegree.getOrDefault(node, 0);
            int inD = inDegree.getOrDefault(node, 0);
            if (inD == 0 && out >= 2) {
                createdNode = node;
                break;
            }
        }

        int totalGraph = outDegree.get(createdNode);
        int stick = 0, eight = 0;

        for (int node : nodes) {
            if (node == createdNode) continue;

            int out = outDegree.getOrDefault(node, 0);
            int inD = inDegree.getOrDefault(node, 0);

            if (out == 0) {
                stick++;
            } else if (out >= 2) {
                eight++;
            }
        }

        int donut = totalGraph - stick - eight;

        return new int[]{createdNode, donut, stick, eight};
    }
}