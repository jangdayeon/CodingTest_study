import java.util.*;

public class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] lastSeen = new int[128]; // ASCII 문자 지원

        // lastSeen 배열 초기화
        Arrays.fill(lastSeen, -1);

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // 이전에 등장한 적 있는지 확인
            if (lastSeen[currentChar] != -1) {
                // 현재 인덱스와 마지막 등장 인덱스의 차이를 계산
                answer[i] = i - lastSeen[currentChar];
            } else {
                // 이전에 등장한 적 없으면 -1
                answer[i] = -1;
            }

            // 현재 문자의 위치를 업데이트
            lastSeen[currentChar] = i;
        }

        return answer;
    }
}