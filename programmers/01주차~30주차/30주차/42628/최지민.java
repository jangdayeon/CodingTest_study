import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeSet<Integer> ts = new TreeSet<>();
        
        for(int i = 0; i < operations.length; i++) {
            String[] op = operations[i].split(" ");
            
            if(op[0].equals("I")) {
                ts.add(Integer.parseInt(op[1]));
            } else if(!ts.isEmpty()) {
                if(op[1].equals("1")) ts.pollLast();
                else if(op[1].equals("-1")) ts.pollFirst();
            }
        }
        
        if(ts.size() == 0) {
            return new int[]{0, 0};
        }
        
        return new int[]{ts.last(), ts.first()};
    }
}