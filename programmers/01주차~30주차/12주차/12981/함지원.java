import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};
        Set<String> using = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            if (i > 0 && (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1) || using.contains(words[i]))) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                return answer;
            }

            using.add(words[i]);
        }

        return answer;
    }
}