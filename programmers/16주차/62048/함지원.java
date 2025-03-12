import java.math.BigInteger;

class Solution {
    public long solution(int W, int H) {
        long w = (long) W;
        long h = (long) H;

        long gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();

        return w * h - (w + h - gcd);
    }
}