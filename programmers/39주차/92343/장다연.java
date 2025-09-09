//답 확인함

import java.util.*;

class Solution {
    private int max = 0;
    private List<Integer>[] tree;
    
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        
        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
        }
        
        // 시작은 0번 노드 방문
        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.addAll(tree[0]);
        dfs(1, 0, info, nextNodes); 
        return max;
    }
    
    private void dfs(int sheep, int wolf, int[] info, List<Integer> nextNodes) {
        max = Math.max(max, sheep);
        
        for (int i = 0; i < nextNodes.size(); i++) {
            int node = nextNodes.get(i);
            int ns = sheep, nw = wolf;
            if (info[node] == 0) ns++; else nw++;
            if (ns <= nw) continue; // 늑대가 같거나 많아지면 불가능
            
            // 다음 후보 리스트 복사
            List<Integer> newList = new ArrayList<>(nextNodes);
            newList.remove(i); // 이번에 방문한 노드 제거
            newList.addAll(tree[node]); // 방문한 노드의 자식 추가
            
            dfs(ns, nw, info, newList);
        }
    }
}
