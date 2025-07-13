class Solution {
    public int solution(int n) {
        int answer = 1;
        
        int one = 0;
        int two = 1;
        
        for(int i = 2; i < n + 1; i++) {
            answer = (one + two) % 1234567;
            one = two;
            two = answer;
        }
        
        return answer;
    }
}