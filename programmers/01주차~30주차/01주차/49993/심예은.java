class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            String skill_str = skill_trees[i].replaceAll("[^" + skill + "]", "");

            int count = 0;
            for (int j = 0; j < skill_str.length(); j++) {
                if (j >= skill.length() || skill.charAt(j) != skill_str.charAt(j)) {
                    count = -1;
                    break;
                }
            }

            // count가 -1이 아니면 올바른 순서로 배치된 것
            if (count != -1) {
                answer++;
            }
        }

        return answer;
    }
}