import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        List<long[]> starPoint = new ArrayList<>();
        
        for(int i = 0; i < line.length; i++) {
            long a = line[i][0], b = line[i][1], e = line[i][2];
            
            for(int j = i + 1; j < line.length; j++) {
                long c = line[j][0], d = line[j][1], f = line[j][2];
                
                long adbc = (a * d) - (b * c);
                if(adbc == 0) continue;
                
                long bfed = (b * f) - (e * d);
                long ecaf = (e * c) - (a * f);
                
                if(bfed % adbc != 0 || ecaf % adbc != 0) continue;
                
                starPoint.add(new long[]{bfed / adbc, ecaf / adbc});
            }
        }
        
        long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE, maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;
        
        for(long[] s : starPoint) {
            minX = Math.min(minX, s[0]);
            minY = Math.min(minY, s[1]);
            maxX = Math.max(maxX, s[0]);
            maxY = Math.max(maxY, s[1]);
        }
        
        char[][] coord = new char[(int)(maxY - minY + 1)][(int)(maxX - minX + 1)];
        String[] answer = new String[coord.length];
        
        for(char[] c : coord) {
            Arrays.fill(c, '.');
        }
        
        for(long[] s : starPoint) {
            coord[(int)(maxY - s[1])][(int)(s[0] - minX)] = '*';
        }
        
        for(int i = 0; i < coord.length; i++) {
            answer[i] = new String(coord[i]);
        }
        
        return answer;
    }
}