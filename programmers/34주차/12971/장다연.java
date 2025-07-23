import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        if(sticker.length == 1) return sticker[0];
        else if(sticker.length == 2) return Math.max(sticker[0],sticker[1]);
        
        int[] dp1 = new int[sticker.length]; //sticker.length-1 인덱스 선택X
        int[] dp2 = new int[sticker.length]; //0번 인덱스 선택X
        dp1[0] = sticker[0];
        dp1[1] = Math.max(sticker[0], sticker[1]);
        dp2[1] = sticker[1];
        for(int i=2; i<sticker.length; i++){
            dp2[i] = Math.max(dp2[i-2]+sticker[i], dp2[i-1]);
            if(i==sticker.length-1) break;
            dp1[i] = Math.max(dp1[i-2]+sticker[i], dp1[i-1]);
        }
        // System.out.println(Arrays.toString(dp1));
        // System.out.println(Arrays.toString(dp2));
        return Math.max(dp1[sticker.length-2], dp2[sticker.length-1]);
    }
}