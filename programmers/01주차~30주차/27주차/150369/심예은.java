class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long totalDistance = 0;

        int deliverRemain = 0;
        int pickupRemain = 0;

        // 가장 먼 집부터 앞으로 진행
        for (int i = n - 1; i >= 0; i--) {
            deliverRemain += deliveries[i];  // 배달할 물건 누적
            pickupRemain += pickups[i];      // 수거할 물건 누적

            // 이번에 이 거리(i+1)까지 몇 번 이동해야 하는지 계산
            while (deliverRemain > 0 || pickupRemain > 0) {
                // 한 번 이동 시 최대 cap만큼 처리 가능
                deliverRemain -= cap;
                pickupRemain -= cap;
                totalDistance += (i + 1) * 2L; // 왕복 거리
            }
        }

        return totalDistance;
    }
}