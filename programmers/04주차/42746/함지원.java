import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = b + a;
                String order2 = a + b;
                return order1.compareTo(order2);
            }
        });

        StringBuilder answer = new StringBuilder();
        for (String num : strNumbers) {
            answer.append(num);
        }

        // 4. 가장 큰 숫자가 0인 경우 처리 (예: [0, 0, 0])
        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer.toString();
    }
}