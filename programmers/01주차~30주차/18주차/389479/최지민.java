class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] serverCnt = new int[players.length];
        for(int i = 0; i < players.length; i++) {
            if(players[i] >= serverCnt[i] * m && serverCnt[i] < players[i] / m) {
                int plusServer = (players[i] / m) - serverCnt[i];
                for(int j = 0; j < k && (i + j) < players.length; j++) {
                    serverCnt[i + j] += plusServer;
                }
                answer += plusServer;
            }
        }
        
        return answer;
    }
}