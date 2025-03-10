class Solution {
    public long solution(int w, int h) {
        int gcdResult = GCD(w, h);
        
        return (long)w * h - ((w / gcdResult) + (h / gcdResult) - 1) * gcdResult;
    }
    
    private int GCD(int a, int b) {
        while(b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}