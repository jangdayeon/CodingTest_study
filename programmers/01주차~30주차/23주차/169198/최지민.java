class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i = 0; i < balls.length; i++) {
            int[] ball = balls[i];
            
            int[][] direction = {
                {-ball[0], ball[1]}, // 왼
                {2 * m - ball[0], ball[1]}, // 오
                {ball[0], -ball[1]}, // 아래
                {ball[0], 2 * n - ball[1]} // 위
            };
            
            int result = Integer.MAX_VALUE;
            
            for(int j = 0; j < 4; j++) {
                if(startX == ball[0] && ((j == 2 && startY > ball[1]) || (j == 3 && startY < ball[1]))) continue;
                if(startY == ball[1] && ((j == 0 && startX > ball[0]) || (j == 1 && startX < ball[0]))) continue;
                
                int dx = startX - direction[j][0];
                int dy = startY - direction[j][1];
                int dist = dx * dx + dy * dy;
                
                result = Math.min(result, dist);
            }
            
            answer[i] = result;
        }
        return answer;
    }
}