import java.util.*;

class Node implements Comparable<Node> {
    int index;
    int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.distance, other.distance);
    }
}

class Solution {
    public static int solution(int N, int[][] road, int K) {
        int INF = (int) 1e9;
        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);
        
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : road) {
            int a = r[0], b = r[1], d = r[2];
            graph.get(a).add(new Node(b, d));
            graph.get(b).add(new Node(a, d));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        distance[1] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int dist = current.distance;
            int now = current.index;

            if (dist > distance[now]) continue;

            for (Node neighbor : graph.get(now)) {
                int cost = distance[now] + neighbor.distance;
                if (cost < distance[neighbor.index]) {
                    distance[neighbor.index] = cost;
                    pq.offer(new Node(neighbor.index, cost));
                }
            }
        }

        int result = 0;
        for (int d : distance) {
            if (d <= K) {
                result++;
            }
        }

        return result;
    }
}
