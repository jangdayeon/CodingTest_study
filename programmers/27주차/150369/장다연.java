class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dRemain = 0;
        int pRemain = 0;

        for (int i = n - 1; i >= 0; i--) {
            dRemain += deliveries[i];
            pRemain += pickups[i];

            // 더 이상 배달/수거할 게 없으면 패스
            while (dRemain > 0 || pRemain > 0) {
                dRemain -= cap;
                pRemain -= cap;
                answer += (i + 1) * 2L;
            }
        }

        return answer;
    }
}
