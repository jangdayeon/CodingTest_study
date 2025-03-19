class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long totalTime = 0;
        int left = 1, right = getArrayMax(diffs), mid = (left + right) / 2;
        
        while(left < right) {
            totalTime = 0;
            mid = (left + right) / 2;
            
            for(int i = 0; i < diffs.length; i++) {
                if(diffs[i] > mid) {
                    totalTime += ((diffs[i] - mid) * (times[i] + times[i - 1])) + times[i];
                } else {
                    totalTime += times[i];
                }
                
                if(totalTime > limit) break;
            }
            System.out.println(totalTime);
            if(totalTime > limit) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private int getArrayMax(int[] arr) {
        int result = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            if(result < arr[i]) result = arr[i];
        }
        
        return result;
    }
}