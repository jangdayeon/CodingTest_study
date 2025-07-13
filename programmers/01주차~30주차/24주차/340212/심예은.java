class Solution {

    // 클래스 필드로 diffs, times 저장 (calculateTime 호출 시 인자 간소화)
    int[] diffs, times;

    // calculateTime에서 더 간결한 변수명 사용 및 (long) 캐스팅 위치 명확화
    public long calculateTime(int level) {
        long total = 0;
        int prevTime = 0;

        for (int i = 0; i < diffs.length; i++) {
            int curTime = times[i];

            if (diffs[i] <= level) {
                total += curTime;
            } else {
                int mistakes = diffs[i] - level;
                total += (long)mistakes * (curTime + prevTime) + curTime;
            }

            prevTime = curTime; // 이전 퍼즐 시간 갱신
        }

        return total;
    }

    public int solution(int[] diffs, int[] times, long limit) {
        // 매개변수를 클래스 필드에 저장
        this.diffs = diffs;
        this.times = times;

        int left = 1, right = 100_000; // 가독성을 위한 자리수 구분

        while (left < right) {
            int mid = (left + right) / 2;
            if (calculateTime(mid) <= limit) {
                right = mid; // 제한시간 안이면 숙련도 줄여보기
            } else {
                left = mid + 1; // 초과면 숙련도 높이기
            }
        }

        return left;
    }
}
