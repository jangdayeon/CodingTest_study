class Solution {
    public int[] solution(long begin, long end) {
        int size = (int)(end - begin + 1);
        int[] answer = new int[size];

        for (long num = begin; num <= end; num++) {
            answer[(int)(num - begin)] = getMaxDivisor(num);
        }

        return answer;
    }

    private int getMaxDivisor(long num) {
        if (num == 1) return 0;

        int max = 1;

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                long pair = num / i;

                if (pair <= 10_000_000) {
                    // 짝 약수가 조건 만족 → 더 큰 값이므로 저장
                    max = (int)Math.max(max, pair);
                }

                if (i <= 10_000_000) {
                    // 작은 약수도 조건 만족하면 고려
                    max = (int)Math.max(max, i);
                }
            }
        }

        return max;
    }
}