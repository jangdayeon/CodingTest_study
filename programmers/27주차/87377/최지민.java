import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        String[] answer;
        
        List<long[]> ip = new ArrayList<>();
        for(int i = 0; i < line.length; i++) {
            for(int j = i + 1; j < line.length; j++) {
                long a = line[i][0], b = line[i][1], e = line[i][2];
                long c = line[j][0], d = line[j][1], f = line[j][2];
            
                if(a * d - b * c == 0) continue;
                
                double x = (b*f - e*d) / (double)(a*d - b*c);
                double y = (e*c - a*f) / (double)(a*d - b*c);
                //System.out.println(x + " " + y);
                if((long)x == x && (long)y == y) {
                    ip.add(new long[]{(long)x, (long)y});
                }
            }
        }
        
        long minX = 100001, minY = 100001, maxX = -100001, maxY = -100001;
        for(long[] p : ip) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
            maxX = Math.max(maxX, p[0]);
            maxY = Math.max(maxY, p[1]);
        }
        
        char[][] coord = new char[(int)(maxY - minY + 1)][(int)(maxX - minX + 1)];
        answer = new String[coord.length];
        
        for(int i = 0; i < coord.length; i++) {
            Arrays.fill(coord[i], '.');
        }
        
        for(long[] p : ip) {
            coord[(int)(maxY - p[1])][(int)(p[0] - minX)] = '*';
        }
        
        for(int i = 0; i < coord.length; i++) {
            answer[i] = new String(coord[i]);
        }
        
        return answer;
    }
}