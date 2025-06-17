import java.util.*;

class Solution {
    final int INF = (int) 1e9;
    ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    
    private class Node {
        int index;
        int distance;
        
        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
    
    public void dijkstra(int start, int[] d) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
        
        pq.offer(new Node(start, 0));
        d[start] = 0;
        
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            
            if(node.distance > d[node.index]) continue;
            
            for(int i = 0; i < graph.get(node.index).size(); i++) {
                int cost = d[node.index] + graph.get(node.index).get(i).distance;
                
                if(cost < d[graph.get(node.index).get(i).index]) {
                    d[graph.get(node.index).get(i).index] = cost;
                    pq.offer(new Node(graph.get(node.index).get(i).index, cost));
                }
            }
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }
        
        for(int[] r : road) {
            graph.get(r[0]).add(new Node(r[1], r[2]));
            graph.get(r[1]).add(new Node(r[0], r[2]));
        }
        
        int[] d = new int[N + 1];
        Arrays.fill(d, INF);
        
        dijkstra(1, d);
        
        for(int result : d) {
            if(result <= K) {
                answer++;
            }
        }

        return answer;
    }
}