class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] minutes = new int[1440];

        for (String[] book : book_time) {
            int start = minutesChange(book[0]);
            int end = Math.min(1439, minutesChange(book[1]) + 10);

            for (int i = start; i < end; i++) {
                minutes[i]++;
            }
        }

        for (int i = 900; i < 1440; i++) {
            answer = Math.max(answer, minutes[i]);
        }
        return answer;
    }
}