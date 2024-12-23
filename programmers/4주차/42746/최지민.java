import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] numberList = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
        
        Arrays.sort(numberList, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));
        
        String result = String.join("", numberList);
        
        return result.charAt(0) == '0' ? "0" : result;
    }
}