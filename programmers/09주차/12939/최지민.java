import java.util.*;

class Solution {
    public String solution(String s) {
        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        return String.valueOf(arr[0]) + " " + String.valueOf(arr[arr.length - 1]);
    }
}