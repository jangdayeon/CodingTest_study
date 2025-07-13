import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            int attack = enemy[i];
            n -= attack;
            pQ.offer(attack);
            answer++;

            if (n < 0) {
                if (k > 0) {
                    n += pQ.poll();
                    k--;
                } else return answer - 1;
            }
        }

        return answer;
    }
}