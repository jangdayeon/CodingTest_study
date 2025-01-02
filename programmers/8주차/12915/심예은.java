import java.util.*;

public class Solution {
    public String[] solution(String[] strings, int n) {

        // Arrays.sort()에 Comparator 전달
        Arrays.sort(strings, (s1, s2) -> {
            // n번째 문자를 기준으로 비교
            if (s1.charAt(n) == s2.charAt(n)) {
                // n번째 문자가 같다면, 사전순으로 정렬
                return s1.compareTo(s2);
            } else {
                // n번째 문자를 기준으로 정렬
                return Character.compare(s1.charAt(n), s2.charAt(n));
            }
        });

        return strings;
    }
}
