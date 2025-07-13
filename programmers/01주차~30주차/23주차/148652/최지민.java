class Solution {
    private long count(int n, long k) {
        if(n == 0) {
            return 1;
        }
        
        long blockCnt = (long) Math.pow(5, n - 1);
        long oneCnt = (long) Math.pow(4, n - 1);
        
        long blockNum = k / blockCnt;
        if(k % blockCnt == 0) blockNum--;
        
        long innerIdx = (k % blockCnt == 0) ? blockCnt : k % blockCnt;
        
        if(blockNum == 2) {
            return oneCnt * blockNum;
        } else if(blockNum < 2) {
            return oneCnt * blockNum + count(n - 1, innerIdx);
        } else {
            return oneCnt * (blockNum - 1) + count(n - 1, innerIdx);
        }
    }
    
    public int solution(int n, long l, long r) {
        return (int)(count(n, r) - count(n, l - 1));
    }
}