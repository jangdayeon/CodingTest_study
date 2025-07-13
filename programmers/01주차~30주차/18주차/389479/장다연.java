//최대 이용자 수 = m, 서버 한 대가 운영 가능한 시간 = k
import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        List<Integer> nowServer = new ArrayList<>(); //현재 각 서버별 남은 시간 저장
        for(int i=0; i<players.length; i++){
            for(int j=nowServer.size()-1; j>=0; j--){ //종료된 서버는 삭제
                nowServer.set(j,nowServer.get(j)-1);
                if(nowServer.get(j)==0) {
                    nowServer.remove(j);
                    continue;
                }
            }
            int nowSeatingCapacity = nowServer.size()*m;//현재 수용 가능한 사람 수 
            if(players[i] > nowSeatingCapacity){
                int needServer = players[i] / m;
                int now = nowServer.size(); //이거 따로 변수 안 빼면 for문 오류 발생
                for(int j =0; j< needServer - now; j++){
                    nowServer.add(k);
                    answer++;
                }
            }
            // System.out.println(i+" "+nowServer);
        }
        
        return answer;
    }
}