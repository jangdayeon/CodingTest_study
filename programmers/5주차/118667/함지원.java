import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long total = 0, q1Sum = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        // total값과 queue1 총합 구하기
        for(int i = 0; i < queue1.length; i++) {
            total += queue1[i] + queue2[i];
            q1Sum += queue1[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        // queue1과 queue2의 총합이 홀수면 -1 return
        if(total % 2 != 0) return -1;

        long target = total / 2;
        while (true) {
            if (answer > queue1.length * 3) return -1;
            if (q1Sum == target) break;
            else if (q1Sum > target) {
                q1Sum -= q1.peek();
                q2.add(q1.poll());
            } else {
                q1Sum += q2.peek();
                q1.add(q2.poll());
            }
            answer++;
        }
        return answer;
    }
}