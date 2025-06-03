class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        for(long i = l - 1; i < r; i++) {
            String five = Long.toString(i, 5);
            if(!five.contains("2")) answer++;
        }
        
        return answer;
    }
}