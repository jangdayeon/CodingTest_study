class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cntZero = 0, len = 0, cnt = 0;

        while (!s.equals("1")) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') cntZero++;
                else len++;
            }

            s = Integer.toString(len, 2);
            len = 0;
            cnt++;
        }
        answer[0] = cnt;
        answer[1] = cntZero;

        return answer;
    }
}