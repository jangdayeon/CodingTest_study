import java.util.Arrays;

public class Solution {
    public int solution(int[] people, int limit) {
        // 몸무게 배열 정렬
        Arrays.sort(people);

        int left = 0; // 가장 가벼운 사람의 인덱스
        int right = people.length - 1; // 가장 무거운 사람의 인덱스
        int boats = 0; // 필요한 구명보트 개수

        // 투 포인터를 이용한 계산
        while (left <= right) {
            // 가장 가벼운 사람과 가장 무거운 사람이 함께 탈 수 있는 경우
            if (people[left] + people[right] <= limit) {
                left++; // 가장 가벼운 사람 태움
            }
            // 가장 무거운 사람은 항상 보트에 태움
            right--;
            boats++; // 보트를 사용
        }
        return boats;
    }
}
