import java.util.*;

class Plan {
    String name;
    int remainTime;
    
    public Plan(String name, int remainTime) {
        this.name = name;
        this.remainTime = remainTime;
    }
}

class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        
        Arrays.sort(plans, (a, b) -> changeMin(a[1]) - changeMin(b[1]));

        Deque<Plan> deque = new ArrayDeque<>();
        
        for(int i = 0; i < plans.length - 1; i++) {
            int nowTime = changeMin(plans[i][1]);
            int nextTime = changeMin(plans[i + 1][1]);
            
            int remainTime = nextTime - nowTime;
            int needTime = Integer.parseInt(plans[i][2]);
            
            if(remainTime < needTime) {
                deque.addFirst(new Plan(plans[i][0], needTime - remainTime));
            } else if(remainTime >= needTime) {
                answer.add(plans[i][0]);
                remainTime -= needTime;
                
                while(!deque.isEmpty() && remainTime > 0) {
                    Plan p = deque.poll();
                    
                    if(p.remainTime > remainTime) {
                        p.remainTime -= remainTime;
                        deque.addFirst(p);
                        remainTime = 0;
                    } else {
                        remainTime -= p.remainTime;
                        answer.add(p.name);
                    }
                }
            }
        }
        
        answer.add(plans[plans.length - 1][0]);
        
        while(!deque.isEmpty()) {
            answer.add(deque.poll().name);
        }
        
        return answer.toArray(new String[0]);
    }
    
    private int changeMin(String time) {
        String[] nowTime = time.split(":");
        
        return Integer.parseInt(nowTime[0]) * 60 + Integer.parseInt(nowTime[1]);
    }
}