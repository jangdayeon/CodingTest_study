//모르겠어서 답 확인..
//in과 out set을 만들어야 함
//그리고 그래프 특징
// 생성한 정점 -> in 0개, out 3개
// 막대 모양 그래프 -> in 1개, out 1개
// 8자 모양 그래프 -> in 2개, out 2개
// 도넛 모양 그래프 -> 생성한 정점의 out - 막대 모양과 8자 모양 그래프 개수
//이게 될 수 있는 이유는 딴 모양의 그래프는 없다고 했기 때문임!! 
import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4]; //생성한 정점의 번호, 도넛 모양 그래프의 수, 막대 모양 그래프의 수, 8자 모양 그래프의 수
        Map<Integer, Set<Integer>> in = new HashMap<>();
        Map<Integer, Set<Integer>> out = new HashMap<>();
        Set<Integer> nodes = new HashSet<>();
        for(int[] e : edges){
            nodes.add(e[0]);
            nodes.add(e[1]);
            
            Set<Integer> inSet = in.getOrDefault(e[1], new HashSet<>());
            Set<Integer> outSet = out.getOrDefault(e[0], new HashSet<>());
            inSet.add(e[0]);
            outSet.add(e[1]);
            in.put(e[1], inSet);
            out.put(e[0], outSet);
        }
        // System.out.println(in);
        // System.out.println(out);
        
        for(int n : nodes){
            Set<Integer> inSet = in.getOrDefault(n, new HashSet<>());
            Set<Integer> outSet = out.getOrDefault(n, new HashSet<>());
            
            //생성한 정점
            if(inSet.size()==0 && outSet.size()>=2){
                answer[0] = n;
                continue;
            }
            
            //막대 모양 그래프
            if(inSet.size()>=1 && outSet.size()==0){
                answer[2]++;
                continue;
            }
            
            //8자 모양 그래프
            if(inSet.size()>=2 && outSet.size()==2){
                answer[3]++;
                continue;
            }
        }
        //도넛 모양 그래프
        answer[1] = out.get(answer[0]).size() - answer[2] - answer[3];
        
        return answer;
    }
}