import java.util.LinkedList;

public class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        LinkedList<String> word = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {
            if (i > 0 && (word.contains(words[i]) || words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0))) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                return answer;
            }
            word.add(words[i]);
        }
        return answer;
    }
}
