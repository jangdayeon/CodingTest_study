import java.util.*;

class Solution {
    class Node {
        int index;
        long distance;
        
        public Node(int index, long distance) {
            this.index = index;
            this.distance = distance;
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        long answer = Long.MAX_VALUE;
        
        Map<Integer, List<Node>> graph = new HashMap<>();
        
        for(int i = 1; i <= n; i++) graph.put(i, new ArrayList<>());
        
        for(int[] f : fares) {
            graph.get(f[0]).add(new Node(f[1], f[2]));
            graph.get(f[1]).add(new Node(f[0], f[2]));
        }
        
        long[] ds = dijkstra(s, graph, n);
        long[] da = dijkstra(a, graph, n);
        long[] db = dijkstra(b, graph, n);
        
        for(int i = 1; i <= n; i++) {
            if(ds[i] == Long.MAX_VALUE || da[i] == Long.MAX_VALUE || db[i] == Long.MAX_VALUE) continue;
            long cost = ds[i] + da[i] + db[i];
            if(cost < answer) answer = cost;
        }
        
        return (int) answer;
    }
    
    private long[] dijkstra(int start, Map<Integer, List<Node>> graph, int n) {
        long[] d = new long[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.distance, b.distance));
        
        pq.offer(new Node(start, 0));
        d[start] = 0;
        
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            
            if(d[node.index] < node.distance) continue;
            
            for(int i = 0; i < graph.get(node.index).size(); i++) {
                long cost = d[node.index] + graph.get(node.index).get(i).distance;
                
                if(cost < d[graph.get(node.index).get(i).index]) {
                    d[graph.get(node.index).get(i).index] = cost;
                    pq.offer(new Node(graph.get(node.index).get(i).index, cost));
                }
            }
        }
        
        return d;
    }
}