import java.util.*;

class Solution {
    private class Stone{
        int idx;
        int value;
        public Stone(int idx, int value){
            this.idx = idx;
            this.value = value;
        }
        @Override
        public String toString(){
            return value+"";
        }
    }
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        Deque<Stone> q = new ArrayDeque<>();
        for(int i=0; i<stones.length; i++){
            while(!q.isEmpty() && q.peekLast().value < stones[i]){
                q.removeLast();
            }
            
            q.addLast(new Stone(i,stones[i]));
            
            if(i < k - 1) continue;
            
            if(q.peekFirst().idx <= i-k){
                q.removeFirst();
            }
            answer = Math.min(answer, q.peekFirst().value);
            // System.out.println(q);
            // System.out.println(answer);
        }
        
        return answer;
    }
}