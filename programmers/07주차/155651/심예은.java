class Solution {
    private static final int MAX_TIME = 1450;
    private static final int HOUR = 60;
    private static final int CLEAN_TIME = 10;

    public int solution(String[][] book_time) {
        int answer = 0;

        int[] rooms = new int[MAX_TIME];

        for (String[] time : book_time) {
            String inTime = time[0];
            String outTime = time[1];

            rooms[calTime(inTime)] += 1;
            rooms[calTime(outTime) + CLEAN_TIME] -= 1;
        }

        // 누적합
        for (int i = 1; i < MAX_TIME; i++) {
            rooms[i] += rooms[i - 1];
            answer = Math.max(answer, rooms[i]);
        }
        return answer;
    }
    private static int calTime(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]) * 60;
        int minute = Integer.parseInt(split[1]);

        return hour + minute;
    }
}