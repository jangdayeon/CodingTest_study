import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int BIdx = B.length-1;
        for(int i=A.length-1; i>-1; i--){
            if(A[i] < B[BIdx]){
                answer++;
                BIdx--;
            }
        }
        return answer;
    }
}