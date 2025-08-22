class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++) {
            answer = Math.max(answer, check(s, i, i + 1)); // 짝
            answer = Math.max(answer, check(s, i, i) - 1); // 홀
        }

        return answer;
    }
    
    private int check(String s, int l, int r) {
        int cnt = 0;
        
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            cnt++;
        }
        
        return cnt * 2;
    }
} 