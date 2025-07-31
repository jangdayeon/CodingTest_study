import java.util.*;

class Edge {
    int distance;
    int nodeA;
    int nodeB;
    
    public Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }
}
class Solution {
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<Edge> graph = new ArrayList<>();
        
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        for(int i = 0; i < costs.length; i++) {
            int[] cost = costs[i];
            graph.add(new Edge(cost[2], cost[0], cost[1]));
        }
        
        for(int i = 0; i < graph.size(); i++) {
            Edge e = graph.get(i);
            
            if(findParent(e.nodeA) != findParent(e.nodeB)) {
                unionParent(e.nodeA, e.nodeB);
                answer += e.distance;
            }
        }
        
        return answer;
    }
    
    private int findParent(int node) {
        if(node == parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }
    
    private void unionParent(int nodeA, int nodeB) {
        nodeA = findParent(nodeA);
        nodeB = findParent(nodeB);
        if(nodeA < nodeB) parent[nodeB] = nodeA;
        else parent[nodeA] = nodeB;
    }
}