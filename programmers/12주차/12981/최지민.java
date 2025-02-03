import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> wordSet = new HashSet<>();
        wordSet.add(words[0]);

        for(int i = 1; i < words.length; i++) {
            if(words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)
              || wordSet.contains(words[i])) {
                return new int[]{i - ((i / n) * n) + 1, (i / n) + 1};
            }
            
            wordSet.add(words[i]);
        }

        return new int[]{0, 0};
    }
}