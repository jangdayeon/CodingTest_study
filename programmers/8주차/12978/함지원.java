import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int vertex, time;

        Node(int vertex, int time) {
            this.vertex = vertex;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time; // 시간 오름차순 정렬
        }
    }

    public int solution(int N, int[][] road, int K) {
        // 그래프 초기화
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 도로 정보 추가 (양방향)
        for (int[] r : road) {
            graph.get(r[0]).add(new Node(r[1], r[2]));
            graph.get(r[1]).add(new Node(r[0], r[2]));
        }

        // 다익스트라 알고리즘
        int[] distances = new int[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[1] = 0;

        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(1, 0)); // 시작 노드

        while (!pQ.isEmpty()) {
            Node current = pQ.poll();
            int currentVertex = current.vertex;
            int currentTime = current.time;

            if (currentTime > distances[currentVertex]) continue;

            for (Node neighbor : graph.get(currentVertex)) {
                int newTime = currentTime + neighbor.time;
                if (newTime < distances[neighbor.vertex]) {
                    distances[neighbor.vertex] = newTime;
                    pQ.offer(new Node(neighbor.vertex, newTime));
                }
            }
        }

        // K 이하의 시간에 도달할 수 있는 마을 개수 계산
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (distances[i] <= K) answer++;
        }

        return answer;
    }
}