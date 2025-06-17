import java.util.*;

public class Solution {
    public int solution(int x, int y, int n) {
        // BFS 탐색을 위한 큐. [현재 숫자, 연산 횟수] 형태로 저장
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0}); // 시작 숫자와 연산 횟수 0을 큐에 넣음

        // 방문한 숫자를 기록하는 배열 (최대 숫자 y까지 확인)
        boolean[] visited = new boolean[y + 1];
        visited[x] = true; // 시작 숫자 방문 처리

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 큐에서 숫자와 연산 횟수 꺼냄
            int currentNumber = current[0];
            int currentCount = current[1];

            // 목표 숫자 y에 도달하면 연산 횟수를 반환
            if (currentNumber == y) {
                return currentCount;
            }

            // 가능한 다음 숫자를 계산
            int[] nextNumbers = {currentNumber * 2, currentNumber * 3, currentNumber + n};

            for (int next : nextNumbers) {
                // 다음 숫자가 y보다 크면 탐색하지 않음
                if (next > y) continue;

                // 아직 방문하지 않은 숫자라면 큐에 추가
                if (!visited[next]) {
                    visited[next] = true; // 방문 처리
                    queue.add(new int[]{next, currentCount + 1}); // 연산 횟수 +1
                }
            }
        }

        // 모든 경우를 탐색해도 y에 도달하지 못한 경우
        return -1;
    }
}
