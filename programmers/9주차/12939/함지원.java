class Solution {
    public String solution(String s) {

        String[] numbers = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String x : numbers) {
            min = Math.min(Integer.parseInt(x), min);
            max = Math.max(Integer.parseInt(x), max);
        }

        return String.valueOf(min) + " " + String.valueOf(max);
    }
}