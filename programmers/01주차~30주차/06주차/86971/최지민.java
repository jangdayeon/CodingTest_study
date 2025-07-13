import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    
    public int bfs(int start, boolean[] visited) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        
        int cnt = 0;
        
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int x = queue.poll();
            
            cnt++;
            for(int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if(!visited[y]) {
                    queue.offer(y);
                    visited[y] = true;
                }
            }
        }
        
        return cnt;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        for(int i = 0; i < n + 1; i++) {
            this.graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < wires.length; i++) {
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        
        for(int i = 0; i < wires.length; i++) {
            boolean[] visited = new boolean[n + 1];
            
            graph.get(wires[i][0]).remove(Integer.valueOf(wires[i][1]));
            graph.get(wires[i][1]).remove(Integer.valueOf(wires[i][0]));
            
            int cnt = bfs(1, visited);
            int remain = n - cnt;
            
            if(Math.abs(cnt - remain) < answer) {
                answer = Math.abs(cnt - remain);
            }
            
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        
        return answer;
    }
}