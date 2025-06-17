public class Solution {
    public String solution(String s) {
        String answer = "";
        boolean isFirstChar = true; // 단어의 첫 문자인지 여부

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                // 공백은 그대로 추가
                answer += c;
                isFirstChar = true; // 다음 문자가 단어의 첫 글자
            } else {
                // 단어의 첫 글자는 대문자, 나머지는 소문자
                if (isFirstChar) {
                    answer += Character.toUpperCase(c);
                } else {
                    answer += Character.toLowerCase(c);
                }
                isFirstChar = false; // 첫 글자 이후로 변경
            }
        }
        return answer;
    }
}