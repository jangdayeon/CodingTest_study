//dp
import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long[] startedPlus = new long[sequence.length];
        long[] startedMinus = new long[sequence.length];
        startedPlus[0] = sequence[0];
        startedMinus[0] = sequence[0] * -1;
        long answer = Math.max(startedPlus[0], startedMinus[0]);
        for(int i=1; i<sequence.length; i++){
            int sp = i % 2 == 0 ? 1 : -1;
            int sm = i % 2 != 0 ? 1 : -1;
            startedPlus[i] = startedPlus[i-1] + sp * sequence[i] > sp * sequence[i] ? startedPlus[i-1] + sp * sequence[i] : sp * sequence[i];
            startedMinus[i] = startedMinus[i-1] + sm * sequence[i] > sm * sequence[i] ? startedMinus[i-1] + sm * sequence[i] : sm * sequence[i];
            
            answer = Math.max(startedPlus[i], answer);
            answer = Math.max(startedMinus[i], answer);
        }
        // System.out.println(Arrays.toString(startedPlus));
        // System.out.println(Arrays.toString(startedMinus));
        return answer;
    }
}