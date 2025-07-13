class Solution {
    public int solution(int[] players, int m, int k) {

        int totalAdditions = 0;  // 총 서버 증설 횟수
        int[] expireAt = new int[24]; // 해당 시간대에 만료될 서버 수
        int activeServers = 0;  // 현재 운영 중인 서버 수

        for (int hour = 0; hour < 24; hour++) {
            // 만료된 서버 제거하는 코드
            if (expireAt[hour] != 0) {
                activeServers -= expireAt[hour];
            }

            // 현재 필요한 서버 개수 계산
            int requiredServers = players[hour] / m;

            if (players[hour] >= m) {
                if (activeServers < requiredServers) {
                    int additionalServers = requiredServers - activeServers;
                    activeServers += additionalServers;
                    totalAdditions += additionalServers;

                    // k시간 후 서버 만료 설정
                    if (hour + k > 23) {
                        expireAt[hour + k - 23] = additionalServers;
                    } else {
                        expireAt[hour + k] = additionalServers;
                    }
                }
            }
        }
        return totalAdditions;
    }
}