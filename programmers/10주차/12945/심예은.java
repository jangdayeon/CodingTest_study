public class Solution9 {
    private static int[] answer;

    public static int solution(int n) {
        answer = new int[n + 1]; // 크기 n+1의 배열 생성
        return fibonacci(n);
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n; // 기저 조건
        }
        if (answer[n] != 0) {
            return answer[n]; // 이미 계산된 값이면 반환
        }
        answer[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567; // 재귀 호출
        return answer[n];
    }
}
