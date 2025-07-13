import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        int answerIdx = 0;

        List<Integer> numbers = new ArrayList<>();
        numbers.add(-111);

        for (int i = 1; i <= n; i++) numbers.add(i);

        while (n > 1) {
            int idx = (int) ((k - 1) / factorial(n - 1) + 1);

            answer[answerIdx++] = numbers.get(idx);
            numbers.remove(idx);

            k -= (idx - 1) * factorial(n - 1);
            n--;
        }

        answer[answerIdx] = numbers.get(1);

        return answer;
    }

    public long factorial(int n) {
        if (n == 1) return 1L;

        return n * factorial(n - 1);
    }
}