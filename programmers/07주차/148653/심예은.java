class Solution {
    public int solution(int storey) {
        int answer = 0;

        // storey가 0이 될 때까지 반복 (모든 자리수 처리)
        while (storey != 0) {
            int cnt = storey % 10; // 현재 자리수를 추출

            // 현재 자리수를 기준으로 조작 방향 결정
            if (cnt > 5) {
                cnt -= 10;
                cnt = Math.abs(cnt);
                storey += cnt;
            } else if (cnt == 5) {
                if ((storey / 10) % 10 >= 5) {
                    cnt = 5;
                    storey += cnt;
                }
                // 다음 자리수가 5 미만일 경우 내림 처리
            }
            // 내림 처리 또는 올림 처리 후 자리수 이동
            storey /= 10;
            answer += cnt;
        }
        return answer;
    }
}