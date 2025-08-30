import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] leftList = new int[a.length];
        int[] rightList = new int[a.length];
        
        leftList[0] = a[0];
        rightList[a.length - 1] = a[a.length - 1];
        for(int i = 1; i < leftList.length; i++) {
            if(leftList[i - 1] > a[i]) leftList[i] = a[i];
            leftList[i] = (leftList[i - 1] > a[i]) ? a[i] : leftList[i - 1];
        }
        
        for(int i = a.length - 2; i > -1; i--) {
            rightList[i] = (rightList[i + 1] > a[i]) ? a[i] : rightList[i + 1];
        }
        
        for(int i = 0; i < a.length; i++) {
            if(leftList[i] >= a[i] || rightList[i] >= a[i]) answer++;
        }
        
        return answer;
    }
}