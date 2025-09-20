import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] deleted = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = (i == n - 1) ? -1 : i + 1;
        }
        
        Deque<int[]> deque = new ArrayDeque<>();
        int cur = k;
        
        for(String cm : cmd) {
            char c = cm.charAt(0);
                
            if(c == 'U' || c == 'D') {
                int cnt = Integer.parseInt(cm.substring(2));
                    
                while(cnt > 0) {
                    cur = (c == 'U') ? prev[cur] : next[cur];
                    cnt--;
                }
            } else if(c == 'C') {
                deleted[cur] = true;
                deque.offerLast(new int[]{cur, prev[cur], next[cur]});
                    
                if(prev[cur] != -1) next[prev[cur]] = next[cur];
                if(next[cur] != -1) prev[next[cur]] = prev[cur];
                    
                cur = (next[cur] != -1) ? next[cur] : prev[cur];
            } else {
                if(!deque.isEmpty()) {
                    int[] re = deque.pollLast();
                    deleted[re[0]] = false;
                        
                    if(re[1] != -1) next[re[1]] = re[0];
                    if(re[2] != -1) prev[re[2]] = re[0];
                    prev[re[0]] = re[1];
                    next[re[0]] = re[2];
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) sb.append((deleted[i]) ? 'X' : 'O');
        
        return sb.toString();
    }
}