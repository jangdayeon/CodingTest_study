import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length() / 2; i++) {
            String tmp = s.substring(0, i);
            String pressString = "";
            int cnt = 1;
            
            for(int j = i; j < s.length(); j += i) {
                String current = s.substring(j, Math.min(j + i, s.length()));
                
                if(current.equals(tmp)) {
                    cnt++;
                } else {
                    pressString += (cnt > 1 ? cnt : "") + tmp;
                    tmp = current;
                    cnt = 1;
                }
            }
            
            pressString += (cnt > 1 ? cnt : "") + tmp;
            answer = Math.min(answer, pressString.length());
        }
        
        return answer;
    }
}