import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String s = String.valueOf(n);

        for (char x : s.toCharArray()) answer += x - '0';

        return answer;
    }
}