import java.util.*;

class Solution {
    String[] user_id;
    String[] banned_id;
    
    Set<String> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;
        
        combination(new ArrayList<>(), new boolean[user_id.length], 0, user_id.length, banned_id.length);
        
        return result.size();
    }
    
    private void combination(List<String> comb, boolean[] visited, int start, int n, int r) {
        if(start == r) {
            if(check(comb)) {
                List<String> tmp = new ArrayList<>(comb);
                Collections.sort(tmp);
                result.add(String.join(" ", tmp));
            }
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            comb.add(user_id[i]);
            combination(comb, visited, start + 1, n, r);
            comb.remove(comb.size() - 1);
            visited[i] = false;
        }
    }
    
    private boolean check(List<String> comb) {
        boolean flag = true;
        
        for(int i = 0; i < banned_id.length; i++) {
            String ban = banned_id[i];
            String user = comb.get(i);
            
            if(ban.length() != user.length()) return false;
            
            for(int j = 0; j < ban.length(); j++) {
                if(ban.charAt(j) == '*') continue;
                else {
                    if(ban.charAt(j) != user.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
            }
        }
        
        return flag;
    }
}