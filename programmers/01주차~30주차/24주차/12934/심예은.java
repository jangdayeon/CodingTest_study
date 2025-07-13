class Solution {
    public long solution(long n) {
        // 제곱근을 구함
        long sqrt = (long) Math.sqrt(n);

        // 제곱한 값이 n과 같다면 (sqrt + 1)^2 리턴
        if (sqrt * sqrt == n) {
            return (sqrt + 1) * (sqrt + 1);
        }

        // 아니라면 -1 리턴
        return -1;
    }
}
