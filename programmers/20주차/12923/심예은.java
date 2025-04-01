class Solution {
    public int[] solution(long begin, long end) {
        int len = (int)(end - begin + 1);
        int[] answer = new int[len];

        for (long i = begin; i <= end; i++) {
            if (i == 1) {
                answer[(int)(i - begin)] = 0;
                continue;
            }

            // i의 약수 중 가장 큰 값 찾기 (자기 자신 제외, 10,000,000 이하)
            int maxDivisor = 1;
            for (long j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    long pair = i / j;

                    if (pair <= 10000000) {
                        maxDivisor = (int)pair;
                        break; // 가장 큰 약수니까 바로 끝냄
                    }

                    if (j <= 10000000) {
                        maxDivisor = Math.max(maxDivisor, (int)j);
                    }
                }
            }
            answer[(int)(i - begin)] = maxDivisor;
        }
        return answer;
    }
}
