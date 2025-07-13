import java.util.*;

class Solution {
    public List<int[]> solution(int n) {
        List<int[]> answer = new ArrayList<>();
        hanoi(n, 1, 3, 2, answer);

        return answer;
    }

    private void hanoi(int n, int from, int to, int aux, List<int[]> answer) {
        if (n == 1) {
            answer.add(new int[]{from, to});
            return;
        }

        hanoi(n - 1, from, aux, to, answer);
        answer.add(new int[]{from, to});
        hanoi(n - 1, aux, to, from, answer);
    }
}