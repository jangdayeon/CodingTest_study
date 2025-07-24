class Solution {
    public int solution(int sticker[]) {
        int[] s1 = new int[sticker.length];
        int[] s2 = new int[sticker.length];
        
        if(sticker.length < 3) {
            return (sticker.length == 1) ? sticker[0] : Math.max(sticker[0], sticker[1]);
        }
        
        s1[0] = sticker[0];
        s1[1] = sticker[0];
        for(int i = 2; i < sticker.length - 1; i++) {
            s1[i] = Math.max(s1[i - 1], s1[i - 2] + sticker[i]);
        }
        
        s2[1] = sticker[1];
        for(int i = 2; i < sticker.length; i++) {
            s2[i] = Math.max(s2[i - 1], s2[i - 2] + sticker[i]);
        }

        return Math.max(s1[sticker.length - 2], s2[sticker.length - 1]);
    }
}