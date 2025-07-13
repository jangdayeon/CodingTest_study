import java.util.*;

public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> iWant = new HashMap<>();

        for (int i = 0; i < want.length; i++) iWant.put(want[i], number[i]);

        for (int i = 0; i + 9 <= discount.length - 1; i++) {
            Map<String, Integer> sliding = new HashMap<>();

            for (int j = 0; j < 10; j++) {
                sliding.put(discount[i + j], sliding.getOrDefault(discount[i + j], 0) + 1);
            }

            if (sliding.equals(iWant)) answer++;
        }

        return answer;
    }
}
