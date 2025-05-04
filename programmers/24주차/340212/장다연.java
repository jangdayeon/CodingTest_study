//틀릴 경우(diff > level) -> ( prev + cur ) * (diff - level) + cur
//맞힐 경우(diff <= level) -> cur
//숙련도를 이진 탐색으로 ( 1 ~ 100_000 ) 찾아내기 
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        return minLevel(diffs, times, limit);
    }
    private int minLevel(int[] diffs, int[] times, long limit){
        int min = 1;
        int max = 100_000;
        
        int answer = 100_000;
        while(min <= max){
            int mid = (min + max) / 2;
            if(canSolve(diffs, times, limit, mid)) {
                max = mid - 1;
                answer = mid;
            }
            else min = mid + 1;
        }
        
        return answer;
    }
    private boolean canSolve(int[] diffs, int[] times, long limit, long level){
        long usedTime = 0;
        for(int i=0; i<diffs.length; i++){
            int diff = diffs[i];
            int prev = i == 0 ? 0 : times[i-1];
            int cur = times[i];
            if(diff > level) usedTime += ( prev + cur ) * (diff - level) + cur;
            else usedTime += cur;
            
            if(usedTime > limit) return false;
        }
        return true;
    }
}