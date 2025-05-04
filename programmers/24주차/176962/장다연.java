import java.util.*;

class Plan implements Comparable<Plan>{
    private String name;
    private int start;
    private int restTime;
    
    public Plan(String name, int start, int restTime){
        this.name = name;
        this.start = start;
        this.restTime = restTime;
    }
    
    public int compareTo(Plan p){
        return this.start - p.start;
    }
    
    public static Plan create(String[] plan){
        String planName = plan[0];
        int planStart = convertToMin(plan[1]);
        int planPlayTime = Integer.parseInt(plan[2]);
        return new Plan(planName, planStart, planPlayTime);
    }
    
    private static int convertToMin(String t){
        String[] time = t.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
    
    public void setRestTime(int restTime){
        this.restTime = restTime;
    }
    
    public int getRestTime(){
        return this.restTime;
    }
    
    public int getStart(){
        return this.start;
    }
    
    public String getName(){
        return this.name;
    }
    
    @Override
    public String toString(){
        return name+" "+start+" "+restTime;
    }
    
}

class Solution {
    public String[] solution(String[][] plans) {
        TreeSet<Plan> planSet = new TreeSet<>();
    
        for(String[] p : plans){
            Plan createdPlan = Plan.create(p);
            planSet.add(createdPlan);
        }
        
        return getOrder(planSet);
    }
    
    private String[] getOrder(TreeSet<Plan> s){
        String[] rtn = new String[s.size()];
        int rtnIdx = 0;
        
        Deque<Plan> restPlans = new LinkedList<>();
        while(!s.isEmpty()){
            Plan now = s.pollFirst();
            
            if(s.isEmpty()) {
                rtn[rtnIdx++] = now.getName();
                break;
            }
            
            Plan next = s.first();
            if(now.getStart()+now.getRestTime() > next.getStart()){
                //기존 진행 중인 과제를 멈춰야 할 경우
                now.setRestTime((now.getStart()+now.getRestTime()) - next.getStart());
                restPlans.add(now);
            } else if(now.getStart()+now.getRestTime() <= next.getStart()){
                //기존 진행 중인 과제 끝낼 수 있을 경우
                rtn[rtnIdx++] = now.getName();
                
                int rest = next.getStart() - (now.getStart()+now.getRestTime());
                
                while(!restPlans.isEmpty() && rest > 0){
                    Plan temp = restPlans.pollLast();
                    if(temp.getRestTime() <= rest) {
                        rtn[rtnIdx++] = temp.getName();
                        rest -= temp.getRestTime();
                    } else{
                        temp.setRestTime(temp.getRestTime() - rest);
                        restPlans.add(temp);
                        break;
                    }
                }
            }
        }
        
        while(!restPlans.isEmpty()){
            rtn[rtnIdx++] = restPlans.pollLast().getName();
        }
        
        return rtn;
    }
}