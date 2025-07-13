import java.util.*;

class Solution {
    private enum Direct {
        UP, DOWN, LEFT, RIGHT;
    }
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        Arrays.fill(answer, Integer.MAX_VALUE);
        for(int i=0; i<balls.length; i++){
            int[] b = balls[i];
            //상 -> x가 같고 startY가 더 작으면 안됨
            if(!(startX == b[0] && startY < b[1])){
                answer[i] = Math.min(answer[i], calculateDirect(Direct.UP, startX, startY, b[0], b[1], m, n));
            }
            //하 -> x가 같고 startY가 더 크면 안됨
            if(!(startX == b[0] && startY > b[1])){
                answer[i] = Math.min(answer[i], calculateDirect(Direct.DOWN, startX, startY, b[0], b[1], m, n));
            }
            //좌 -> y가 같고 startX가 더 크면 안됨
            if(!(startY == b[1] && startX > b[0])){
                answer[i] = Math.min(answer[i], calculateDirect(Direct.LEFT, startX, startY, b[0], b[1], m, n));
            }
            //우 -> y가 같고 startX가 더 작으면 안됨
            if(!(startY == b[1] && startX < b[0])){
                answer[i] = Math.min(answer[i], calculateDirect(Direct.RIGHT, startX, startY, b[0], b[1], m, n));
            }
        }
        return answer;
    }
    private int calculateDirect(Direct d, int sX, int sY, int eX, int eY, int m, int n){
        int answer = 0;
        switch(d){
            case UP -> answer = (int) Math.pow(eX-sX,2) + (int) Math.pow(n+(n-sY)-eY,2);
            case DOWN -> answer = (int) Math.pow(eX-sX,2) + (int) Math.pow(sY+eY,2);
            case LEFT -> answer = (int) Math.pow(eY-sY,2) + (int) Math.pow(sX+eX,2);
            case RIGHT -> answer = (int) Math.pow(eY-sY,2) + (int) Math.pow(m+(m-sX)-eX,2);
        }
        return answer;
    }
}