//구현, 수학 -> 이진탐색
import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int max = Arrays.stream(diffs).max().getAsInt();
        int min = Arrays.stream(diffs).min().getAsInt();
                
        return binarySearch(limit, diffs, times, min, max);
    }
    public int binarySearch(long limit, int[] diffs, int[] times, int min, int max){
        while(min <= max) {
            int mid = (min + max) / 2;
            long result = puzzle(mid, diffs, times);
            // System.out.println(mid+" "+result);
            if (result <= limit) {
                if(puzzle(mid-1, diffs, times) > limit) return mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
    
    public long puzzle(int x, int[] diffs, int[] times){ //x == 숙련도
        long result = 0;
        for(int i=0; i<diffs.length; i++){
            if(diffs[i] <= x) result += times[i];
            else {
                if (i == 0) { // i가 0일 경우 times[i-1] 참조 방지
                    result += times[i] * (diffs[i] - x) + times[i];
                } else {
                    result += (times[i - 1] + times[i]) * (diffs[i] - x) + times[i];
                }
            }
        } 
        return result;
    }
}