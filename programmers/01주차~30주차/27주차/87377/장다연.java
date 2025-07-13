import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        
        Set<String> starPos = new HashSet<>();
        
        for(int i=0; i<line.length; i++){
            for(int j=i+1; j<line.length; j++){
                long a = line[i][0];
                long b = line[i][1];
                long c = line[i][2];
                long d = line[j][0];
                long e = line[j][1];
                long f = line[j][2];
                
                long denominator = a * e - b * d;
                if (denominator == 0) continue; // 평행이거나 일치

                long xNumerator = b * f - c * e;
                long yNumerator = c * d - a * f;

                if (xNumerator % denominator != 0 || yNumerator % denominator != 0) continue; // 정수 교점 아님

                long x = xNumerator / denominator;
                long y = yNumerator / denominator;

                maxX = Math.max(maxX, x);
                minX = Math.min(minX, x);
                maxY = Math.max(maxY, y);
                minY = Math.min(minY, y);
                
                starPos.add(x+" "+y);
            }
        }
        
        List<String> list = new ArrayList<>(starPos);
        
        char[][] board = new char[(int)(maxY - minY) + 1][(int)(maxX - minX) + 1];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }

        for(String l : list){
            long x = Long.parseLong(l.split(" ")[0]);
            long y = Long.parseLong(l.split(" ")[1]);
            board[(int)(maxY-y)][(int)(x-minX)] = '*';
        }
        
        String[] answer = new String[board.length];
        for(int i=0; i<board.length; i++){
            answer[i] = new String(board[i]);
        }
        return answer;
        
    }
}