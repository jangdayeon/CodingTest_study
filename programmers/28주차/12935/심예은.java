import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        // 배열의 길이가 1이면 [-1]을 반환
        if (arr.length == 1) {
            return new int[]{-1};
        }

        // 가장 작은 값 찾기
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }

        // 결과 배열 생성 (길이는 arr.length - 1)
        int[] answer = new int[arr.length - 1];
        int index = 0;

        // 가장 작은 수를 제외하고 새로운 배열에 복사
        for (int num : arr) {
            if (num != min) {
                answer[index++] = num;
            }
        }

        return answer;
    }
}