class Solution {
    public long solution(int n) {
        long answer = 0;
        
        long one = 0;
        long two = 1;
        
        for(int i = 1; i <= n; i++) {
            answer = (one + two) % 1234567;
            one = two;
            two = answer;
        }
        
        return answer;
    }
}