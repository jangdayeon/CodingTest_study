import java.util.*;

class Solution {
    char[] kakao = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    char[] result = new char[8];
    
    int answer = 0;
    
    private void photo(boolean[] visited, int idx, String[] data)  {
        if(idx == 8) {
            if(check(data)) {
                answer++;
            }
            return;
        }
        
        for(int i = 0; i < 8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[idx] = kakao[i];
                photo(visited, idx + 1, data);
                visited[i] = false;
            }
        }
    }
    
    private boolean check(String[] data) {
        for(String d : data) {
            char onef = d.charAt(0);
            char twof = d.charAt(2);
            
            int idxOne = 0, idxTwo = 0;
            for(int i = 0; i < 8; i++) {
                if(result[i] == onef) idxOne = i;
                if(result[i] == twof) idxTwo = i;
            }
            
            int distance = Math.abs(idxOne - idxTwo) - 1;
            int condition = d.charAt(4) - '0';
            
            switch(d.charAt(3)) {
                case '=':
                    if(distance != condition) return false;
                    break;
                case '<':
                    if(distance >= condition) return false;
                    break;
                case '>':
                    if(distance <= condition) return false;
                    break;
            }
        }
        
        return true;
    }
    
    public int solution(int n, String[] data) {
        photo(new boolean[8], 0, data);
        
        return answer;
    }
}