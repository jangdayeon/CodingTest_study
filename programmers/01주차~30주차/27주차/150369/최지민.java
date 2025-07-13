class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int totalD = 0;
        int totalP = 0;
        for(int i = pickups.length - 1; i > -1; i--) {
            totalD += deliveries[i];
            totalP += pickups[i];
            
            while(totalD > 0 || totalP > 0) {
                answer += (i + 1) * 2;

                totalD -= cap;
                totalP -= cap;
            }
        }
        
        return answer;
    }
}