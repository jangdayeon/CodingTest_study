class Solution {
    public String solution(String s) {
        int len = s.length();
        int mid = len / 2;

        // 길이가 홀수인 경우 -> 가운데 글자 1개
        if (len % 2 == 1) {
            return s.substring(mid, mid + 1);
        }
        // 길이가 짝수인 경우 -> 가운데 글자 2개
        else {
            return s.substring(mid - 1, mid + 1);
        }
    }
}