import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        List<List<Integer>> board = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            board.add(new ArrayList<Integer>());
        }
        
        int targetIdx = -1;
        for(int i=0; i<words.length; i++){ //50
            if(words[i].equals(target)) targetIdx = i;
            for(int j=0; j<words.length; j++){ //49
                if(i==j) continue; 
                if(canChange(words[i], words[j])) board.get(i).add(j);
            }
        }
        if(targetIdx == -1) return 0;
        
        int[] cost = new int[words.length];
        Arrays.fill(cost, Integer.MAX_VALUE);
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<words.length; i++){
            if(canChange(begin, words[i])) {
                dq.add(i);
                cost[i] = 1;
            }
        }
        while(!dq.isEmpty()){
            int now = dq.remove();
            for(int next : board.get(now)){
                if(cost[next] > cost[now]) {
                    cost[next] = cost[now]+1;
                    dq.add(next);
                } 
            } 
        }
        // System.out.println(Arrays.toString(cost));
        
        return cost[targetIdx];
    }
    private boolean canChange(String a, String b){
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        int sameCnt = 0;
        for(int z=0; z<c1.length; z++){ //10
            if(c1[z] == c2[z]) sameCnt++;
        }
        if(sameCnt == c1.length-1) return true;
        else return false;
    }
}