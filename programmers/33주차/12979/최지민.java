class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int cover = 2 * w + 1, start = 1;
        for(int i = 0; i < stations.length; i++) {
            int gap = (stations[i] - w) - start;
            
            if(gap > 0) {
                answer += (gap + cover - 1) / cover;
            }
            
            start = stations[i] + w + 1;
        }
        
        if(start <= n) {
            int gap = n - start + 1;
            answer += (gap + cover - 1) / cover;
        }
      
        return answer;
    }
}