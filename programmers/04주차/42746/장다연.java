import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 1. int[] -> String[]로 변환
        String[] nums = Arrays.stream(numbers)
                              .mapToObj(Integer::toString)
                              .toArray(String[]::new);
        
        // 2. 두 문자열을 합친 값으로 비교
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));  // b + a와 a + b를 비교

        // 3. 정렬된 배열을 연결
        String answer = String.join("", nums);
        
        // 4. 앞자리가 0인 경우 처리 (예: "000" -> "0")
        if (answer.startsWith("0")) return "0";

        return answer;
    }
}
