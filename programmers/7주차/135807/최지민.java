class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        if (check(gcdA, arrayB)) {
            answer = Math.max(answer, gcdA);
        }

        if (check(gcdB, arrayA)) {
            answer = Math.max(answer, gcdB);
        }
        
        return answer;
    }
    
    private int gcd(int a, int b) {
        while(b > 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
    
    private boolean check(int gcdValue, int[] array) {
        for(int a : array) {
            if(a % gcdValue == 0) {
                return false;
            }
        }
        return true;
    }
}