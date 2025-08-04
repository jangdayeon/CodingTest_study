class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        long s1 = 0, s2 = 0;
        for(int i = 0; i < sequence.length; i++) {
            int seq = sequence[i];
            long v1 = (i % 2 == 0) ? seq : -seq;
            long v2 = (i % 2 == 0) ? -seq : seq;
            
            s1 = Math.max(s1 + v1, v1);
            s2 = Math.max(s2 + v2, v2);
            
            answer = Math.max(answer, Math.max(s1, s2));
        }
    
        return answer;
    }
}