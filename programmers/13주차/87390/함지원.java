import java.util.*;

public class Solution {
    public int[] solution(int n, long left, long right) {
        LinkedList<Integer> answer = new LinkedList<>();

        for (long i = left; i <= right; i++) {
            answer.add(Math.max((int) (i / n) + 1, (int) (i % n) + 1));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}