class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        for(long i=l-1; i<r; i++){
            String num = Long.toString(i, 5); 
            if(num.indexOf("2") == -1) answer++;
            }
        return answer;
    }
}