import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e : edge){
            graph.get(e[0]-1).add(e[1]-1);
            graph.get(e[1]-1).add(e[0]-1);
        }
        // System.out.println(graph);
        return bfs(graph, n);
    }
    private int bfs(List<List<Integer>> g, int n){
        Deque<Integer> q = new ArrayDeque<>();
        int[] shortest = new int[n];;
        Arrays.fill(shortest,Integer.MAX_VALUE);
        q.add(0);
        shortest[0] = 1;
        while(!q.isEmpty()){
            int now = q.remove();
            for(int next : g.get(now)){
                if(shortest[next] > shortest[now]+1) {
                    shortest[next] = shortest[now]+1;
                    q.add(next);
                }
            }
        }
        
        return cntFarthest(shortest);
    }
    private int cntFarthest(int[] shortest){
        int answer = 0;
        // System.out.println(Arrays.toString(shortest));
        Arrays.sort(shortest);
        int max = shortest[shortest.length-1];
        for(int i=shortest.length-1; i>=0; i--){
            if(max != shortest[i]) break;
            answer++;
        }
        return answer;
    }
}