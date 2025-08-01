import java.util.*;
class Solution {
    private class Edge implements Comparable<Edge>{
        int from;
        int to;
        int w;
        public Edge(int from, int to, int w){
            this.from = from;
            this.to = to;
            this.w = w;
        }
        @Override
        public int compareTo(Edge e){
            return this.w - e.w;
        }
    }
    private Map<Integer, List<Edge>> board;
    private Map<Integer, Boolean> visited;
    public int solution(int n, int[][] costs) {
        board = new HashMap<>();
        for(int[] cost : costs){
            List<Edge> li0 = board.getOrDefault(cost[0], new ArrayList<>());
            li0.add(new Edge(cost[0], cost[1], cost[2]));
            board.put(cost[0], li0);
            
            List<Edge> li1 = board.getOrDefault(cost[1], new ArrayList<>());
            li1.add(new Edge(cost[1], cost[0], cost[2]));
            board.put(cost[1], li1);
        }
        
        visited = new HashMap<>();
        int start = -1;
        for(int key : board.keySet()){
            visited.put(key, false);
            start = key;
        }
        return dijkstra(start);
    }
    
    private int dijkstra(int start){
        int answer = 0;
        visited.put(start, true);
        PriorityQueue<Edge> q = new PriorityQueue<>();
        for(Edge e : board.get(start)){
            q.add(e);
        }
        while(!q.isEmpty()){
            Edge now = q.remove();
            if(!visited.get(now.to)){
                visited.put(now.to, true);
                answer += now.w;
                for(Edge next : board.get(now.to)){
                    q.add(next);
                }
            }
        }
        return answer;
    }
}