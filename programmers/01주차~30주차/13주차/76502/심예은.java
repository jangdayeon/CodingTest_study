import java.util.*;

public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int count = 0;

        // 원하는 제품과 개수를 리스트로 저장
        List<String> wantList = new ArrayList<>();
        for (int i = 0; i < want.length; i++) {
            for (int j = 0; j < number[i]; j++) {
                wantList.add(want[i]);
            }
        }
        Collections.sort(wantList); // 정렬하여 비교 쉽게 만들기

        // 슬라이딩 윈도우 탐색
        for (int i = 0; i <= discount.length - 10; i++) {
            List<String> currentList = new ArrayList<>();

            // 10일 동안 할인받을 제품을 리스트에 저장
            for (int j = i; j < i + 10; j++) {
                currentList.add(discount[j]);
            }
            Collections.sort(currentList); // 정렬하여 비교

            // 두 리스트가 같다면 회원가입 가능
            if (wantList.equals(currentList)) count++;
        }

        return count;
    }
}