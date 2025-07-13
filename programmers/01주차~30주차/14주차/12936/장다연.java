//중복 없는 순열 구하기
//재귀로 해결

//그냥 모음사전처럼 문제를 풀어보자
import java.util.*;

class Solution {
	public int[] solution(int n, long k) {
		List<Integer> nums = new LinkedList<>();
		long totalCasesCnt = 1; // n!
		int[] answer = new int[n];

		// n! 계산 & 1~n까지 숫자 리스트 초기화
		for (int i = 1; i <= n; i++) {
			totalCasesCnt *= i;
			nums.add(i);
		}

		// k번째를 인덱스0부터인 값으로 변경
		k--;

		long nowCasesCnt = n; // n, n-1, ..., 1
		int index = 0;

		while (nowCasesCnt > 0) {
			totalCasesCnt /= nowCasesCnt; // (n-1)!
			int selectedIndex = (int) (k / totalCasesCnt); //몇번째 묶음인지
			answer[index++] = nums.remove(selectedIndex);
			k %= totalCasesCnt; // 다음 순번 갱신(선택된 묶음 내에서 순번)
			nowCasesCnt--;
		}

		return answer;
	}
}
