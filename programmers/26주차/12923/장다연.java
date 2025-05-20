class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)end-(int)begin+1];
        for(long i = begin; i<=end; i++){
            answer[(int)i-(int)begin] = divisor(i);
        }
        return answer;
    }
    //자기 자신을 제외한 가장 큰 약수가 저장된다.
    private int divisor(long n){
        if(n==1) return 0;
        int rtn = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if(n/i > 10_000_000) {
                    rtn = Math.max(rtn, i);
                    continue;
                }
                return (int) n / i;
            }   
        }
        return rtn;
    }
}