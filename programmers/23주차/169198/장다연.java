import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        //가로의 길이 = m, 세로의 길이 = n
        int[] answer = new int[balls.length];
        Arrays.fill(answer,(int) 1e9);
        
        int[] from = new int[]{startX, startY}; //치기 전
        for(int i=0; i<balls.length; i++){
            int[] to = balls[i]; //친 후
            
            //상
            if(!(from[0] == to[0] && from[1] < to[1])){ //x좌표가 같아 벽 부딪히기 전에 공이 부딪히는 경우 제외
                int line = (int) Math.pow(to[0] - from[0],2) + (int) Math.pow(n+(n-from[1])-to[1],2);
                answer[i] = Math.min(answer[i], line);
            }
            
            //하
            if(!(from[0] == to[0] && from[1] > to[1])){ //x좌표가 같아 벽 부딪히기 전에 공이 부딪히는 경우 제외
                int line = (int) Math.pow(to[0] - from[0],2) + (int) Math.pow(to[1] + from[1],2);
                
                answer[i] = Math.min(answer[i], line);
            }
            
            //좌
            if(!(from[1] == to[1] && from[0] > to[0])){ //y좌표가 같아 벽 부딪히기 전에 공이 부딪히는 경우 제외
                int line = (int) Math.pow(from[0] + to[0],2) + (int) Math.pow(to[1] - from[1],2);
                
                answer[i] = Math.min(answer[i], line);
            }
            
            //우
            if(!(from[1] == to[1] && from[0] < to[0])){ //y좌표가 같아 벽 부딪히기 전에 공이 부딪히는 경우 제외
                int line = (int) Math.pow(m+(m-to[0]) - from[0],2) + (int) Math.pow(to[1] - from[1],2);
                answer[i] = Math.min(answer[i], line);
            }
        }
        
        return answer;
    }
}