import java.util.*;

class Solution {

    private static String[] operation = {"+-*", "+*-", "-+*", "-*+", "*+-", "*-+"};

    public long solution(String expression) {
        long answer = 0;
        List<Long> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        separate(expression, numbers, operators);

        for (String operate : operation) answer = Math.max(answer, priority(numbers, operators, operate));

        return answer;
    }

    private long priority(List<Long> numbers, List<Character> operators, String operate) {
        List<Long> number = new ArrayList<>(numbers);
        List<Character> operator = new ArrayList<>(operators);

        for (char o : operate.toCharArray()) {
            for (int i = 0; i < operator.size(); ) {
                if (operator.get(i) == o) {
                    long sum = calculate(number.get(i), number.get(i + 1), o);
                    number.remove(i + 1);
                    number.set(i, sum);
                    operator.remove(i);
                } else i++;
            }
        }

        return Math.abs(number.get(0));
    }

    private long calculate(long num1, long num2, char o) {
        switch (o) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                return 0L;
        }
    }

    private void separate(String expression, List<Long> numbers, List<Character> operators) {
        int start = 0;

        for (int i = 0; i < expression.length(); i++) {
            char x = expression.charAt(i);

            if (x == '+' || x == '-' || x == '*') {
                numbers.add(Long.parseLong(expression.substring(start, i)));
                operators.add(x);
                start = i + 1;
            }
        }

        numbers.add(Long.parseLong(expression.substring(start)));
    }
}