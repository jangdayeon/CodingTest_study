//1억 이하의 자연수면 o(n)
//계산식
//겹치는 사각형의 개수 : 가로 + 세로 - gcd(가로, 세로)

//gcd는 유클리드 호제법으로 구현

class Solution {
    public long solution(int w, int h) {
    return (long) w * h - ((long) w + h - gcd(w, h));
}
    private long gcd(long w, long h){
        if(h==0) return w;
        return gcd(h, w%h);
    }
}