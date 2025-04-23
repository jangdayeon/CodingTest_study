class Solution {
    public int solution(int n, long l, long r) {
        int count = 0;
        for (long i = l; i <= r; i++) {
            if (isOne(n, i)) count++;
        }
        return count;
    }

    private boolean isOne(int n, long idx) {
        if (n == 0) return true;

        long blockSize = (long) Math.pow(5, n - 1);
        long blockNum = (idx - 1) / blockSize;

        if (blockNum == 2) return false;

        return isOne(n - 1, (idx - 1) % blockSize + 1);
    }
}
