import java.util.*;

class Solution {
    public long calculateTime(int level, int[] diffs, int[] times) {
        long totalTime = 0;
        int n = diffs.length;
        int timePrev = 0; // 이전 퍼즐의 소요 시간

        for (int i = 0; i < n; i++) {
            int diff = diffs[i];
            int timeCur = times[i];

            if (diff <= level) {
                totalTime += timeCur; // 숙련도가 충분하면 그냥 해결,,
            } else {
                int mistakes = diff - level; // 틀리는 횟수
                totalTime += mistakes * (timeCur + timePrev) + timeCur;
            }

            timePrev = timeCur; // 이전 퍼즐의 시간을 갱신하는 코드
        }

        return totalTime;
    }

    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1, right = 100000; // 숙련도의 최소, 최대 범위

        while (left < right) {
            int mid = (left + right) / 2;
            long time = calculateTime(mid, diffs, times);

            if (time <= limit) {
                right = mid; // 시간이 제한 내라면 숙련도를 더 낮춰보고
            } else {
                left = mid + 1; // 시간이 초과하면 숙련도를 높이기
            }
        }

        return left;
    }
}