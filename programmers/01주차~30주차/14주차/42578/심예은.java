import java.util.HashMap;

public class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        // 1. 각 의류 종류별 개수를 저장
        for (String[] cloth : clothes) {
            String type = cloth[1];  // 의류 종류 (key)
            map.put(type, map.getOrDefault(type, 0) + 1);  // 개수 저장
        }

        // 2. 조합의 개수 계산 (공식 적용)
        int answer = 1;
        for (int count : map.values()) {
            answer *= (count + 1);  // (해당 종류의 옷 개수 + 1) 곱하기
        }

        return answer - 1;  // 모든 옷을 입지 않는 경우 제외
    }
}
