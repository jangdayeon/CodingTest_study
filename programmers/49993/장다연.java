import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int result = 0;
        
        String regex = "[^" + skill + "]";
        for(int i=0; i< skill_trees.length; i++){
            skill_trees[i] = skill_trees[i].replaceAll(regex,"");
        }
        
        for(int i=0; i< skill_trees.length; i++){ 
            if(skill_trees[i].length() == 0) { result += 1; continue; }
            for(int j=0; j< skill.length(); j++){
                char c = skill.charAt(j);
                skill_trees[i]=skill_trees[i].replace(c+"",j+"");
            }
            int max = -1;
            for(int j=0; j< skill_trees[i].length(); j++){
                
                int ii = skill_trees[i].charAt(j) - '0';
                if( max == ii-1 ) { max += 1; }
                else { break; }
                if( j == skill_trees[i].length() - 1) { result += 1; }
            }
            
        }
        return result;
    }
}