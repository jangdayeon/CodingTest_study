import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int n : arr) {
            if(n % divisor == 0) {
                answer.add(n);
            }
        }

        if (answer.isEmpty()) answer.add(-1);

        return answer.stream()
                .mapToInt(i->i)
                .sorted()
                .toArray();
    }
}