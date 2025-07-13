class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i = 0; i < balls.length; i++) {
            int[] b = balls[i];
            
            int[][] direction = {
                {-b[0], b[1]}, //왼
                {b[0], 2 * n - b[1]}, //위
                {2 * m - b[0], b[1]}, //오
                {b[0], -b[1]} // 아래
            };
            
            int minValue = Integer.MAX_VALUE;
            for(int j = 0; j < 4; j++) {
                if(b[0] == startX) {
                    if(j == 1 && b[1] > startY) continue;
                    if(j == 3 && b[1] < startY) continue;
                }
                
                if(b[1] == startY) {
                    if(j == 0 && b[0] < startX) continue;
                    if(j == 2 && b[0] > startX) continue;
                }
                
                int dx = direction[j][0] - startX;
                int dy = direction[j][1] - startY;
                
                minValue = Math.min(minValue, dx * dx + dy * dy);
            }
            
            answer[i] = minValue;
        }
        
        return answer;
    }
}