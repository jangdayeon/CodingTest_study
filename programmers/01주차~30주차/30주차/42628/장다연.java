import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxH = new PriorityQueue<>((o1, o2)-> o2-o1);
        PriorityQueue<Integer> minH = new PriorityQueue<>((o1, o2)-> o1-o2);
        
        for(String o : operations){
            char operSign = o.charAt(0);
            int operNum = Integer.parseInt(o.split(" ")[1]);
            switch(operSign){
                case 'I' :
                    maxH.add(operNum);
                    minH.add(operNum);
                    break;
                case 'D' :
                    switch(operNum){
                        case -1 :
                            if(minH.size()==0) break;
                            int minP = minH.poll();
                            maxH.remove(minP);
                            break;
                        case 1 :
                            if(maxH.size()==0) break;
                            int maxP = maxH.poll();
                            minH.remove(maxP);
                            break;
                    }
            }
        }
        int[] answer = new int[2];
        answer[0] = maxH.peek()==null ? 0 : maxH.peek();
        answer[1] = minH.peek()==null ? 0 : minH.peek();
        return answer;
    }
}