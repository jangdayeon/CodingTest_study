import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        if(n > s) return new int[]{-1}; //자연수로 s를 못 만들 경우
        int[] set = new int[n];
        Arrays.fill(set, s/n);
        int rest = s%n;
        for(int i=n-1; i>0; i--){
            if(rest-- == 0) break;
            set[i] += 1;
        }
        // System.out.println(Arrays.toString(set));
        return set;
    }
}