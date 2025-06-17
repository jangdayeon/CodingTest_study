class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
                
        for(String skillTree: skill_trees) {
            String temp = skillTree.replaceAll("[^" + skill + "]", "");
            
            boolean flag = true;
            for(int i = 0; i < temp.length(); i++) {
                if(skill.charAt(i) != temp.charAt(i)) {
                    flag = false;
                }
            }
            
            if(flag) {
                answer += 1;
            }
        }
        
        return answer;
    }
}