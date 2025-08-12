import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 1;
        long right = (long) n * times[times.length-1];
        long answer = 0;
        while(left <= right){
            long mid = (left+right)/2;
            long evaluateCnt = 0;
            for(int i=0; i<times.length; i++){
                evaluateCnt += mid/times[i];
            }
            // System.out.println(evaluateCnt+" mid : "+mid);
            if(evaluateCnt < n){
                left = mid + 1;
            } else{
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}