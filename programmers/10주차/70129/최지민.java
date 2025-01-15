import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[]{0, 0};
        String sLength = s;
        
        while(!sLength.equals("1")) {
            int zeroCnt = (int) sLength.chars().filter(c -> c == '0').count();
            sLength = Integer.toBinaryString(sLength.length() - zeroCnt);
            
            answer[0]++;
            answer[1] += zeroCnt;
        }
        
        return answer;
    }
}