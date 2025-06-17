import java.util.*;

class Solution {
    private class Subjects {
        public String name;
        public int startTime;
        public int endTime;
        public int time;
        
        public Subjects(String name, int startTime, int time) {
            this.name = name;
            this.startTime = startTime;
            this.endTime = startTime + time;
            this.time = time;
        }
        
        public void setTime(int time) {
            this.time -= time;
        }
    }
    
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        
        List<Subjects> subjectList = new ArrayList<>();
        for(String[] plan : plans) {
            subjectList.add(new Subjects(plan[0], timeToMinute(plan[1]), Integer.parseInt(plan[2])));
        }
        
        Collections.sort(subjectList, Comparator.comparing(s -> s.startTime));
        
        Subjects[] subjectArr = subjectList.toArray(new Subjects[0]);
        
        Stack<Subjects> stack = new Stack<>();
        for(int i = 0; i < subjectArr.length - 1; i++) {
            Subjects now = subjectArr[i];
            Subjects next = subjectArr[i + 1];
            
           if(now.endTime > next.startTime) {
               now.setTime(next.startTime - now.startTime);
               stack.push(now);
           } else {
               answer.add(now.name);
               
               int remainTime = next.startTime - now.endTime;
               while(remainTime > 0 && !stack.isEmpty()) {
                   if(stack.peek().time > remainTime) {
                       stack.peek().setTime(remainTime);
                       remainTime = 0;
                   } else {
                       remainTime -= stack.peek().time;
                       answer.add(stack.pop().name);
                   }
               }
           }
        }
        
        answer.add(subjectArr[subjectArr.length - 1].name);
        
        while(!stack.empty()) {
            answer.add(stack.pop().name);
        }
        
        return answer.toArray(new String[0]);
    }
    
    private static int timeToMinute(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}