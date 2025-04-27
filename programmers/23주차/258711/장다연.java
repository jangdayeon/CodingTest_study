//in, out set을 다 만들자
import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, Set<Integer>> in = new HashMap<>();
        Map<Integer, Set<Integer>> out = new HashMap<>();
        Set<Integer> nodes = new HashSet<>();
        
        for(int[] edge : edges){
            nodes.add(edge[0]);
            nodes.add(edge[1]);
            Set<Integer> inTemp = in.getOrDefault(edge[1], new HashSet<Integer>());
            inTemp.add(edge[0]);
            in.put(edge[1], inTemp);
            Set<Integer> outTemp = out.getOrDefault(edge[0], new HashSet<Integer>());
            outTemp.add(edge[1]);
            out.put(edge[0], outTemp);
        }
        // System.out.println(in);
        // System.out.println(out);
        
        for(int node : nodes){
            Set<Integer> inTemp = in.getOrDefault(node, new HashSet<Integer>());
            Set<Integer> outTemp = out.getOrDefault(node, new HashSet<Integer>());
    
            //[0] 생성한 정점 -> in 0개, out 2개 이상
            if(inTemp.size() == 0 && outTemp.size() >= 2) {
                answer[0] = node;
                continue;
            }
            //[2] 막대 모양 그래프 -> in 1개 이상, out 0개
            if(inTemp.size() >= 1 && outTemp.size() == 0) {
                // System.out.println(node);
                answer[2]++;
                continue;
            }
            //[3] 8자 모양 그래프 -> in 2개 이상, out 2개 이상
            if(inTemp.size() >= 2 && outTemp.size() >= 2) {
                answer[3]++;
                continue;
            }
        }
           
        //[1] 도넛 모양 그래프 -> 생성한 정점의 out 개수 - 막대 모양 그래프의 수 - 8자 모양 그래프의 수
        answer[1] = out.get(answer[0]).size() - answer[2] - answer[3];
        
        return answer;
    }
}