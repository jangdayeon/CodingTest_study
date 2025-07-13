class Solution {
    public int solution(int N, int A, int B) {
        int answer = 0;

        while (A != B) {
            A = (A + 1) / 2;
            B = (B + 1) / 2;
            answer++;
        }

        return answer;
    }
}