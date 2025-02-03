public class Solution {
    public int solution(int n) {
        // n의 이진수에서 1의 개수를 직접 계산
        int targetCount = countOnes(n);
        int next = n + 1;

        // 다음 숫자부터 시작해서 1의 개수가 동일한 가장 작은 숫자 찾기
        while (countOnes(next) != targetCount) {
            next++;
        }

        return next;
    }

    // 숫자를 이진수로 변환하고 1의 개수를 세는 메서드
    private int countOnes(int number) {
        int count = 0;

        while (number > 0) {
            count += number % 2; // 2로 나눴을 때 나머지가 1이면 카운트 증가
            number /= 2; // 숫자를 2로 나눔
        }

        return count;
    }
}