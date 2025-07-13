import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int cursor = name.length() - 1;
        
        for(int i = 0; i < name.length(); i++) {
            char n = name.charAt(i);
            
            answer += Math.min(n - 'A', 'Z' - n + 1);
            
            int next = i + 1;
            while(next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            
            cursor = Math.min(cursor, i + name.length() - next + Math.min(i, name.length() - next));
        }
        
        return answer + cursor;
    }
}