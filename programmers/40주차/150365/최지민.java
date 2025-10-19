import java.util.*;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        
        // 사전순
        char[] direction = {'d', 'l', 'r', 'u'};
        // 현재 위치
        int nx = x, ny = y;
        
        // 남은 이동 횟수
        int remaining = k;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < k; i++) {
            boolean moved = false;
            
            System.out.print("y");
            for(int j = 0; j < 4; j++) {
                int tx = nx + dx[j];
                int ty = ny + dy[j];
                
                if(tx < 1 || ty < 1 || tx > n || ty > m) continue;
                
                int rem = remaining - 1;
                int dis = Math.abs(tx - r) + Math.abs(ty - c); // 맨헤튼 거리

                // 목표까지 남은 거리가 남은 이동 횟수 이내이고, 남은 칸이 짝수여야 함
                if(dis <= rem) {
                    sb.append(direction[j]);
                    nx = tx;
                    ny = ty;
                    remaining = rem;
                    moved = true;
                    break;
                }
            }
            
            if(!moved) return "impossible";
        }
        
        return (nx == r && ny == c && remaining == 0) ? sb.toString() : "impossible";
    }
}