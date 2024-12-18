class Solution {
    public String solution(int n) {
        String answer = "";
        
        String[] arr124 = {"4", "1", "2"};
        
        while(n > 0) {
            int reminder = n % 3;
            if(reminder == 0) n -= 1;
            answer = arr124[reminder] + answer;
            n /= 3;
        }
        
        return answer;
    }
}