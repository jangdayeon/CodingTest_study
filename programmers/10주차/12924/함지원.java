class Solution {
    public int solution(int n) {
        int answer = 0, sum = 0, lt = 1, rt = 1;

        while (lt <= n) {
            if (sum < n) {
                sum += rt;
                rt++;
            } else if (sum > n) {
                sum -= lt;
                lt++;
            } else {
                answer++;
                sum -= lt;
                lt++;
            }
        }

        return answer;
    }
}