import java.util.*;

class Solution {
    char[] kakao = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    HashMap<Character, Integer> picture = new HashMap<>();
    
    String[] data;
    int answer = 0;
    
    public int solution(int n, String[] data) {
        this.data = data;
        kakaoPicture(0, new boolean[8]);
        
        return answer;
    }
    
    private void kakaoPicture(int depth, boolean[] visited) {
        if(depth == 8) {
            if(check()) answer++;
            return;
        }
        
        for(int i = 0; i < 8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                picture.put(kakao[i], depth);
                kakaoPicture(depth + 1, visited);
                visited[i] = false;
            }
        }
    }
    
    private boolean check() {
        for(String d : data) {
            char f1 = d.charAt(0), f2 = d.charAt(2);
            int want = d.charAt(4) - '0';
            
            int distance = Math.abs(picture.get(f2) - picture.get(f1)) - 1;
            
            switch(d.charAt(3)) {
                case '=':
                    if(distance != want) return false;
                    break;
                case '>':
                    if(distance <= want) return false;
                    break;
                case '<':
                    if(distance >= want) return false;
                    break;
            }
        }
        
        return true;
    }
}