class Solution {
    public int solution(int n) {
        int answer = n + 1;
        int cntOnes = Integer.bitCount(n);

        while (Integer.bitCount(answer) != cntOnes) answer++;

        return answer;
    }
}