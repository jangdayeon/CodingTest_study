//답 확인함

import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] f : fares) {
            graph[f[0]].add(new int[]{f[1], f[2]});
            graph[f[1]].add(new int[]{f[0], f[2]});
        }
        
        int[] distFromS = dijkstra(n, graph, s);
        int[] distFromA = dijkstra(n, graph, a);
        int[] distFromB = dijkstra(n, graph, b);
        
        int answer = Integer.MAX_VALUE;
        for (int m = 1; m <= n; m++) {
            int total = distFromS[m] + distFromA[m] + distFromB[m];
            answer = Math.min(answer, total);
        }
        return answer;
    }
    
    private int[] dijkstra(int n, List<int[]>[] graph, int start) {
        int INF = 100_000_000;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], cost = cur[1];
            if (dist[node] < cost) continue;
            
            for (int[] next : graph[node]) {
                int nextNode = next[0], nextCost = next[1];
                if (dist[nextNode] > cost + nextCost) {
                    dist[nextNode] = cost + nextCost;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        return dist;
    }
}
