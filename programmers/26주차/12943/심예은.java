class Solution {
    public int solution(long num) {
        int answer = 0;
        //long n = num; // 홀수 부분에서 int 값이 넘어가는 오버플로우 방지를 위한 형변환

        // num이 1에 도달할 때까지 반복
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;  // 짝수일 때는 2로 나눈다
            } else {
                num = num * 3 + 1;  // 홀수일 때는 3을 곱하고 1을 더한다
            }
            answer++;

            // 500번을 넘어가는 경우 무한 루프를 방지하기 위해 종료 처리
            if (answer > 500) {
                return -1; // 500번 이상 반복되면 -1 반환
            }
        }
        return answer;
    }
}
