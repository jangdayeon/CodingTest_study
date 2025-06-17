import java.util.*;

class Solution {
    private int[][] users;
    private int[] emoticons;
    private int[] sale = {10, 20, 30, 40};
    private int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        
        int[] result = new int[emoticons.length];
        
        combi(0, result);
        
        return answer;
    }
    
    private void combi(int depth, int[] result) {
        if(depth == emoticons.length) {
            checkUser(result);
            return;
        }
        
        for(int i = 0; i < sale.length; i++) {
            result[depth] = sale[i];
            combi(depth + 1, result);
        }
    }
    
    private void checkUser(int[] result) {
        int emoticonPlus = 0;
        int userTotalPrice = 0;
        
        for(int[] u : users) {
            int totalPrice = 0;
            for(int i = 0; i < result.length; i++) {
                if(u[0] <= result[i]) {
                    totalPrice += emoticons[i] - (emoticons[i] * (result[i] * 0.01));
                }
            }
            
            if(totalPrice >= u[1]) {
                emoticonPlus++;
            } else {
                userTotalPrice += totalPrice;
            }
        }
        
        if(answer[0] < emoticonPlus) {
            answer[0] = emoticonPlus;
            answer[1] = userTotalPrice;
        } else if(answer[0] == emoticonPlus && answer[1] < userTotalPrice) {
            answer[0] = emoticonPlus;
            answer[1] = userTotalPrice;
        }
    }
}