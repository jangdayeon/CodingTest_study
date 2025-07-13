import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int cntP = 0, cntY = 0;
        char c;

        for(int i=0; i<s.length(); i++) {
            c = s.charAt(i);

            if (c == 'p' || c == 'P') {
                cntP++;
            } else if (c == 'y' || c == 'Y') {
                cntY++;
            }
        }

        if (cntP == cntY) {
            return answer;
        } else {
            answer = false;
            return answer;
        }
    }
}