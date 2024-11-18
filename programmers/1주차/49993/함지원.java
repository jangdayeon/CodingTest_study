class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            String mySkill = skill_trees[i].replaceAll("[^" + skill + "]", "");
            for (int j = 0; j <= skill.length(); j++) {
                String ex = skill.substring(0, j);
                if (mySkill.equals(ex)) {
                    answer++;
                }
            }
        }
        return answer;
    }
}