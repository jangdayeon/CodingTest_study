import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        List<Set<Integer>> networks = new ArrayList<>();
        for(int i=0; i<n; i++){
            networks.add(new HashSet<>());
        }
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers[i].length; j++){
                if(computers[i][j] == 1 && i != j){
                    Set aSet = networks.get(i);
                    aSet.add(j);
                    networks.set(i, aSet);
                    Set bSet = networks.get(j);
                    bSet.add(i);
                    networks.set(j, bSet);
                }
            }
            
        }
        
        int[] group = bfs(n, networks);
        
        return cntGroup(group);
    }
    private int cntGroup(int[] g){
        Set<Integer> s = new HashSet<>();
        int cnt = 0;
        for(int i=0; i<g.length; i++){
            if(!s.contains(g[i])){
                s.add(g[i]);
                cnt++;
            }
        }
        return cnt;
    }
    private int[] bfs(int n, List<Set<Integer>> networks){
        int[] group = new int[n];
        int groupNum = 0;
        
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<n; i++){
            if(group[i] == 0){
                q.push(i);
                group[i] = ++groupNum;
                while(!q.isEmpty()){
                    int now = q.poll();
                    Set<Integer> s = networks.get(now);
                    for(int ss : s){
                        if(group[ss] == 0) {
                            q.push(ss);
                            group[ss] = groupNum;
                        }
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(group));
        return group;
    }
}