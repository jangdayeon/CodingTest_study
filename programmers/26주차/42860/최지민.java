class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;
        
        for(int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            int aPos = i + 1;
            while(aPos < name.length() && name.charAt(aPos) == 'A') {
                aPos++;
            }
            
            move = Math.min(move, Math.min(2 * i + (name.length() - aPos), (name.length() - aPos) * 2 + i));
        }
        
        return answer + move;
    }
}