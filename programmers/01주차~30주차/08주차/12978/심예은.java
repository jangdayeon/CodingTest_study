import java.util.*;

class Edge implements Comparable<Edge> {
    public int vex; // 도착 마을
    public int cost; // 비용
    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob) {
        return this.cost - ob.cost; // 비용 오름차순 정렬
    }
}

class Solution {
    public int solution(int N, int[][] road, int K) {
        // 그래프 초기화
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Edge>());
        }

        // 그래프 간선 추가
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c)); // 양방향 도로
        }

        // 다익스트라 초기화
        int[] dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0; // 1번 마을에서 출발
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1, 0));

        // 다익스트라 알고리즘
        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;

            if (nowCost > dis[now]) continue;

            for (Edge ob : graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }

        // 결과 계산
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dis[i] <= K) answer++; // K 이하인 마을 수 카운트
        }

        return answer;
    }
}
