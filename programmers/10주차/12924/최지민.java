// 투포인터

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] cntArr = new int[n + 1];
        
        for(int i = 0; i <= n; i++) {
            cntArr[i] = i;
        }
        
        int rt = 1;
        int lt = 0;
        
        int sum = 0;
        
        while(rt <= n) {
            sum += cntArr[rt];
            
            while(sum > n) {
                lt++;
                sum -= cntArr[lt];
            }
            
            if(sum == n) {
                answer++;
            }
            
            rt++;
        }
        
        return answer;
    }
}