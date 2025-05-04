import java.util.*;

class Solution {
    private static final int[] DISCOUNT = {10, 20, 30, 40};

    public int[] solution(int[][] users, int[] emoticons) {
        return getBestChoiceResult(users, emoticons);
    }
    
    private int[] getBestChoiceResult(int[][] users, int[] emoticons){
        int[] rtn = new int[2];
        List<int[]> permutation = new ArrayList<>();
        generatePermutation(new int[emoticons.length], 0, permutation);
        
        for(int[] pmt : permutation){
            int[] rst = getResult(pmt, users, emoticons);
            if((rst[0] > rtn[0]) ||
              (rst[0] == rtn[0] && rst[1] > rtn[1])) {
                rtn = rst;
            }
        }
        return rtn;
    }
    
    private int[] getResult(int[] pmt, int[][] users, int[] emoticons){
        int[] rtn = new int[2];
        int[] usersExpense = new int[users.length];
        
        for(int i=0; i<emoticons.length; i++){
            for(int j=0; j<users.length; j++){
                if(users[j][0] <= pmt[i]) usersExpense[j] += calculateExpense(emoticons[i], pmt[i]); 
            }
        }
        
        for(int i=0; i<usersExpense.length; i++){
            if(usersExpense[i] >= users[i][1]) rtn[0] += 1;
            else rtn[1] += usersExpense[i];
        }
        
        return rtn;
    }
    
    private int calculateExpense(int price, int discountRate){
        return (int) (price * ((100-discountRate) / 100f));
    }
    
    private void generatePermutation(int[] pmt, int r, List<int[]> rst){
        if(r == pmt.length){
            rst.add(pmt.clone());
            return;
        }
        for(int d : DISCOUNT){
            pmt[r] = d;
            generatePermutation(pmt, r+1, rst);
        }
    }
}