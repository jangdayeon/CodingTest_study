//배낭문제
// index == b의 흔적 누적 개수
// value == a를 얼마나 많이 아낄 수 있는지(a가 흔적을 남기지 않은 총합)

class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        int[] dp = new int[m+1];
        int aAll = 0;
        
        for(int i=0; i<info.length; i++){
            aAll += info[i][0];
        }
        
        for(int i=0; i<info.length; i++){
            int a = info[i][0];
            int b = info[i][1];
            for(int j=m-1; j>=b; j--){
                dp[j] = Math.max(dp[j], dp[j-b] + a);
            }
        }
        
        int aEvidence = aAll - dp[m-1];
        answer = aEvidence >= n ? -1 : aEvidence;
        return answer;
    }
}