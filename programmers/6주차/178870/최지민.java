import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, sequence.length};
        
        int index = 0;
        int sum = 0;
        for(int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
            
            while(sum > k) {
                sum -= sequence[index];
                index++;
            }
            
            if(sum == k) {
                if((answer[1] - answer[0]) > (i - index)) {
                    answer[0] = index;
                    answer[1] = i;
                }
                sum -= sequence[index];
                index++;
            }
        }

        return answer;
    }
}