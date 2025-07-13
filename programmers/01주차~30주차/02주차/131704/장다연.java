//컨테이너 : 큐
//보조 컨테이너 : 스택
import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>(); //컨테이너
        for(int i=1;i<=order.length;i++){
            q.add(i);
        }
        Stack<Integer> s = new Stack<>(); //보조 컨테이너
        
        int need = 0;
        while (!q.isEmpty()) {
            int now = q.peek();
            int sPop = 0;
            if(!s.empty()){
                sPop = s.pop();
            }
            
            //1. stack이나 queue에 원하는 상자가 있는지 탐색
            if(order[need] == sPop) {
                need += 1;
                answer +=1;
                continue;
            }
            
            q.remove();
            
            if(order[need] == now) {
                need += 1;
                s.push(sPop);
                answer +=1;
                continue;
            }
            
            //2. 원하는 상자가 없을 경우 queue에 있던 값을 stack으로 이동
            s.push(sPop);
            s.push(now);
            
        }
        
        //3. queue는 다 비워졌는데 stack에 있는 값을 실을 수 있는 경우
        while (!s.isEmpty() && need < order.length) {
            int sPop = s.pop();
            if(order[need] != sPop) {
                break;
            }
            need += 1;
            answer +=1;
        }
        
        return answer;
    }
}