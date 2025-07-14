import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        // 1, 3, 5, 7
        // 2, 2, 6, 8
        
        int i = 0, j = 0;
        while(i < A.length && j < B.length) {
            if(B[j] > A[i]) {
                answer++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        
        return answer;
    }
}