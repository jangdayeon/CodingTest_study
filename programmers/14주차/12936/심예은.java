import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long fact = 1; // fact 변수의 타입을 long으로 변경하여 오버플로우 방지

        // 1부터 n까지 숫자 리스트 만들기 & 팩토리얼 계산
        for (int i = 1; i <= n; i++) {
            list.add(i);
            fact *= i; // n! 계산
        }

        k--; // 0-based index로 변환

        for (int i = 0; i < n; i++) {
            fact /= (n - i);  // (n-1)! 계산
            int index = (int) (k / fact);  // 현재 위치의 숫자 결정
            answer[i] = list.get(index); // 결과 리스트에 추가
            list.remove(index);  // 선택한 숫자는 제거
            k %= fact;  // k 갱신
        }

        return answer;
    }
}