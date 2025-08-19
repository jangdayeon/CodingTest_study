import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        
        Map<Integer, Integer> tt = new HashMap<>(); //시간 대별 대기 크루 수
        
        for(String time : timetable){
            int formattedTime = stringToInt(time);
            tt.put(formattedTime, tt.getOrDefault(formattedTime,0)+1);
        }
        // System.out.println(tt);
        
        //큐에 시간 추가
        PriorityQueue<Integer> ttKeys = new PriorityQueue<>();
        for(int key : tt.keySet()){
            ttKeys.add(key);
        }
        
        //콘의 제일 늦은 도착 시간 찾기
        int startTime = stringToInt("09:00");
        int sleepTime = stringToInt("23:59");
        int answer = -1;
        for(int i=startTime; i<startTime+(n*t) && i<=sleepTime; i+=t){
            int nowEmptySpaces = m;        
            while(!ttKeys.isEmpty() && ttKeys.peek() <= i && nowEmptySpaces > 0){
                int nowTime = ttKeys.peek(); //현재 크루 시간대
                int nowWaits = tt.get(nowTime);
                if(nowEmptySpaces - nowWaits >= 0){ //같은 시간에 들어온 크루 모두 탈 수 있을 경우
                    nowEmptySpaces -= nowWaits;
                    // tt.remove(nowTime); //데이터 남아 있어도 상관 X
                    ttKeys.poll();
                    
                } else{ //같은 시간에 들어온 크루 중간에 잘라야할 경우
                    tt.put(nowTime, nowWaits - nowEmptySpaces);
                    nowEmptySpaces = 0;
                }
                /*
                원래 if - else 각각 answer 값 갱신했는데 그러면 
                
                100, 60, 1, ["09:00", "09:00", "09:00", "09:00", "09:00", "09:00", "09:00", "09:00", "09:00", "09:00", "09:00", "09:00", "09:00", "09:00", "09:00", "09:00", "09:00", "09:00"]
                -> 기댓값 : "08:59"
                -> 끝까지 answer 갱신이 안되고 -1로 남는 문제 발생
                
                1, 10, 2, ["08:59", "09:00", "09:00"] -> 기댓값 : "08:59"
                -> 09:00으로 리턴하는 문제
                
                가 발생한다. 그렇기 때문에 answer 갱신은 크루보다 항상 1분 일찍 도착한 값을 저장해서 무조건 탈 수 있게 하는데, 만약 자리가 남아 있어 더 늦게 탈 수 있으면 while문 밖의 if절을 통해 버스오는 시간인 i로 갱신하게 해야 한다.
                */
                
                answer = nowTime-1; //19~23번 테케 위해 필요
            }
            if(nowEmptySpaces > 0) answer = i;
            // System.out.println(intToString(i)+"->"+intToString(answer));
        }
        return intToString(answer);
    }
    private int stringToInt(String t){
        String[] time = t.split(":");
        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        return hour * 60 + min;
    }
    private String intToString(int t){
        String hour = (t / 60) < 10 ? "0"+(t / 60) : ""+(t / 60);
        String min = (t % 60) < 10 ? "0"+(t % 60) : ""+(t % 60);
        return hour + ":" + min;
    }
}