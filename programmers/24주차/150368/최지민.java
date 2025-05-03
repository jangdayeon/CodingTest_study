class Solution {
    int[] answer = new int[2];
    int[] result;
    int[][] users;
    int[] emoticons;
    
    public int[] solution(int[][] users, int[] emoticons) {
        this.result = new int[emoticons.length];
        this.users = users;
        this.emoticons = emoticons;
        
        emoticonDiscount(0, emoticons.length, new int[]{10, 20, 30, 40});
        
        return answer;
    }
    
    private void emoticonDiscount(int depth, int r, int[] discount) {
        if(depth == r) {
            check();
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            result[depth] = discount[i];
            emoticonDiscount(depth + 1, r, discount);
        }
    }
    
    private void check() {
        int plusUser = 0;
        int emoticonBuy = 0;
        
        for(int i = 0; i < users.length; i++) {
            int total = 0;
            for(int j = 0; j < emoticons.length; j++) {
                if(users[i][0] <= result[j]) {
                    total += (emoticons[j] - (emoticons[j] * (result[j] / 100.0)));
                }
            }
            
            if(total >= users[i][1]) {
                plusUser++;
            } else {
                emoticonBuy += total;
            }
        }
        
        if((answer[0] < plusUser) || (answer[0] == plusUser && answer[1] < emoticonBuy)) {
            answer[0] = plusUser;
            answer[1] = emoticonBuy;
        }
    }
}