import java.util.*;

class Solution {
    public long solution(long n) {
        // 1. long -> String -> char 배열
        char[] arr = String.valueOf(n).toCharArray();

        // 2. 내림차순 정렬
        Arrays.sort(arr);  // 일단 오름차순 정렬
        // 배열 뒤집기 (오름차순 정렬된 걸 반대로)
        for (int i = 0; i < arr.length / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        // 3. 문자열로 만들고 숫자로 변환
        return Long.parseLong(new String(arr));
    }
}