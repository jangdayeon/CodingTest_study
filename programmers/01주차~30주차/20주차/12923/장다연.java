import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int size = (int) end - (int) begin;
        int[] answer = new int[size+1];
        Arrays.fill(answer, 1);
        if(begin == 1) answer[0] = 0;
        for(long i=begin; i<=end; i++){
            for(long j=2; j<=Math.sqrt(i); j++){
                if(i % j == 0 && i != j) {
                    int biggerOne = (int)i/(int)j;
                    int nowIdx = (int)i-(int)begin;
                    if (biggerOne<= 10000000) {
                        answer[nowIdx] = biggerOne;
                        break;
                    } else {
                        answer[nowIdx] = (int)j;
                    }
                }
            }
        }
        return answer;
    }
}