class Solution {
    public String solution(String s) {
        char[] sentence = s.toCharArray();
        int idx = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(sentence[0]));

        while (idx < s.length()) {
            if (sentence[idx - 1] == ' ') sb.append(Character.toUpperCase(sentence[idx]));
            else sb.append(Character.toLowerCase(sentence[idx]));
            idx++;
        }

        return sb.toString();
    }
}