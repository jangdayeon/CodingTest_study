import java.util.*;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        Set<String> structure = new HashSet<>();
        
        for(int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];
            String cur = x + " " + y + " " + a;
            
            if(b == 1) {
                structure.add(cur);
                if(!check(structure)) {
                    structure.remove(cur);
                }
            } else {
                structure.remove(cur);
                if(!check(structure)) {
                    structure.add(cur);
                }
            }
        }
        
        List<int[]> answer = new ArrayList<>();
        for(String s : structure) {
            String[] splitS = s.split(" ");
            answer.add(new int[]{Integer.parseInt(splitS[0]), Integer.parseInt(splitS[1]), Integer.parseInt(splitS[2])});
        }
        
        answer.sort((s1, s2) -> {
            if(s1[0] != s2[0]) return s1[0] - s2[0];
            else if(s1[1] != s2[1]) return s1[1] - s2[1];
            else return s1[2] - s2[2];
        });
        
        return answer.toArray(new int[0][]);
    }
    
    private boolean check(Set<String> structure) {
        for(String s : structure) {
            String[] splitS = s.split(" ");
            
            int x = Integer.parseInt(splitS[0]);
            int y = Integer.parseInt(splitS[1]);
            int a = Integer.parseInt(splitS[2]);
            
            if(a == 0) {
                if(y == 0 || structure.contains(x + " " + (y - 1) + " 0")
                   || structure.contains((x - 1) + " " + y + " 1")
                   || structure.contains(x + " " + y + " 1")) continue;
                return false;
            } else {
                if(structure.contains(x + " " + (y - 1) + " 0")
                  || structure.contains((x + 1) + " " + (y - 1) + " 0")
                  || (structure.contains((x - 1) + " " + y + " 1") 
                      && structure.contains((x + 1) + " " + y + " 1"))) continue;
                return false;
            }
        }
        
        return true;
    }
}