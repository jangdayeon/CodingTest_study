import java.util.*;

public class Solution {
    public int solution(int[] topping) {
        // 1. 오른쪽 토핑 개수 카운트
        int[] rightCount = new int[10_001];  // 토핑 번호는 1~10,000
        int rightKinds = 0;  // 동생이 가질 수 있는 토핑 개수

        for (int t : topping) {
            if (rightCount[t] == 0) rightKinds++;  // 새로운 토핑이면 개수 증가
            rightCount[t]++;
        }

        // 2. 왼쪽 토핑 개수 카운트
        boolean[] leftSet = new boolean[10_001];
        int leftKinds = 0;  // 철수가 가질 수 있는 토핑 개수
        int count = 0;

        for (int i = 0; i < topping.length - 1; i++) {
            int currentTopping = topping[i];

            if (!leftSet[currentTopping]) {
                leftSet[currentTopping] = true;
                leftKinds++;  // 철수의 새로운 토핑 개수 증가
            }

            // 동생의 토핑 개수 관리
            rightCount[currentTopping]--;
            if (rightCount[currentTopping] == 0) rightKinds--;  // 해당 토핑이 사라지면 개수 감소

            // 공평하게 나누어진 경우 카운트 증가
            if (leftKinds == rightKinds) count++;
        }

        return count;
    }
}
