import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new LinkedList<>();
        
        Stack<List<String>> stop = new Stack<>(); //Stack(["korean",30],["english",20])
        
        //시간 배열 정렬
        Arrays.sort(plans,((o1, o2)->o1[1].compareTo(o2[1])));
        
        for(int i=0;i<plans.length-1;i++){
            int now = Arrays.stream(plans[i][1].split(":")).mapToInt(Integer::parseInt).reduce(0,(h,m)->h*60+m);
            int next = Arrays.stream(plans[i+1][1].split(":")).mapToInt(Integer::parseInt).reduce(0,(h,m)->h*60+m);
            int now_need = Integer.valueOf(plans[i][2]);
            if(now + now_need ==next){ // 시간 딱 맞춰 끝낼 수 있다면
                // System.out.println("1번"+now+" "+next+plans[i][0]);
                
                answer.add((String)plans[i][0]);
            } else if(now + now_need < next) { // 끝내고 시간이 남으면
                // System.out.println("2번"+now+" "+next+plans[i][0]);
                answer.add(plans[i][0]);
                int rest = next - now - now_need;
                while(rest > 0){
                    if(!stop.isEmpty()){
                        List<String> tmp = stop.pop();
                // System.out.println("2번"+tmp.get(0));
                        
                        int remainingTime = Integer.parseInt(tmp.get(1));
                        if (remainingTime > rest) {
                            tmp.set(1, Integer.toString(remainingTime - rest));
                            rest = 0;
                            stop.push(tmp);
                            } else if (remainingTime == rest) {
                                rest = 0;
                                answer.add(tmp.get(0));
                            } else {
                            answer.add(tmp.get(0));
                            rest = rest - remainingTime;
                        }
                    } else {
                        break; 
                    }
                }
            } else { //시간 안남으면
                // System.out.println("3번"+now+" "+next+plans[i][0]);
                
                int remainingTime = now_need-next+now;
                stop.push(new ArrayList<>(Arrays.asList(plans[i][0], Integer.toString(remainingTime))));
            }
            
        }
        
        answer.add(plans[plans.length-1][0]);
        while(!stop.isEmpty()){
            answer.add((stop.pop().get(0)));
        }
        
        return answer.toArray(String[]::new);
    }
}