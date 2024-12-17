import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int num : queue1) q1.add(num);
        for (int num : queue2) q2.add(num);

        long s1 = q1.stream().mapToLong(Integer::longValue).sum();
        long s2 = q2.stream().mapToLong(Integer::longValue).sum();

        long total = s1 + s2;

        while (s1 != s2) {
            if (answer > (queue1.length + queue2.length) * 3) return -1;

            if (s1 > s2) {
                if (q1.isEmpty()) return -1;
                int removeOne = q1.remove();
                q2.add(removeOne);
                s1 -= removeOne;
                s2 += removeOne;
            } else {
                if (q2.isEmpty()) return -1;
                int removeOne = q2.remove();
                q1.add(removeOne);
                s1 += removeOne;
                s2 -= removeOne;
            }

            answer++;
        }

        return answer;
    }
}
