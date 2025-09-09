import java.util.*;

class Solution {
    private int[] dx = {1, 0, 0, -1};
    private int[] dy = {0, -1, 1, 0};
    private char[] dirct = {'d', 'l', 'r', 'u'};
    private String result = null;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int[] start = {x-1,y-1};
        int[] end = {r-1,c-1};
        bfs(k, n, m, start, end, new char[k]);
        return result == null? "impossible" : result;
    }
    private void bfs(int k, int n, int m, int[] now, int[] end, char[] rst){
        if(result != null) return;
        
        int dist = Math.abs(now[0] - end[0]) + Math.abs(now[1] - end[1]);
        if(dist > k || (k - dist) % 2 != 0) return;
        
        if(k==0 && (now[0] == end[0] && now[1] == end[1])) {
            // System.out.println("됨"+new String(rst));
            result = new String(rst);
            return;
        } else if(k==0) {
            // System.out.println("안됨"+new String(rst));
            return;
        }
        
        for(int i=0; i<4; i++){
            int[] next = {now[0]+dx[i], now[1]+dy[i]};
            
            if(!canMove(n,m,next)) continue;
            rst[rst.length-k] = dirct[i];
            bfs(k-1, n, m, next, end, rst);
        }
    }
    
    private boolean canMove(int n, int m, int[] next){
        if(next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m) return false;
        return true;
    }
}