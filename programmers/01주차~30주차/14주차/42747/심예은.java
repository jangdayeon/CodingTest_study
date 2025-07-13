import java.util.Arrays;

public class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);  // 인용 횟수 오름차순 정렬
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;  // 현재 논문을 포함하여 인용 횟수 이상의 논문 개수
            if (citations[i] >= h) {  // h번 이상 인용된 논문이 h편 이상인지 확인
                return h;  // 조건 만족 시 최대 h 반환
            }
        }
        return 0;  // H-Index를 만족하는 값이 없으면 0 반환
    }
}
