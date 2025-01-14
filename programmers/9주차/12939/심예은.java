import java.util.*;

public class Solution {
    public String solution(String s) {
        // 입력 문자열을 공백 기준으로 분리
        String[] parts = s.split(" ");
        int[] numbers = new int[parts.length];

        // 문자열 배열을 순회하며 정수로 변환
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }

        // 배열 오름차순 정렬
        Arrays.sort(numbers);

        // 문자열로 변환 후 연결
        String answer = numbers[0] + " " + numbers[numbers.length - 1];

        return answer;
    }
}
