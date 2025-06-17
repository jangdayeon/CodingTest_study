import java.util.HashSet;
import java.util.Iterator;

class Solution1 {
    HashSet<Integer> set = new HashSet<>();

    public boolean isPrime(int number) {
        // 0과 1은 소수가 아니다.
        if (number == 0 || number == 1) return false;

        // 에라토스테네스의 체의 알고리즘을 쓰기 위해 number의 제곱근을 구한다.
        int limit = (int) Math.sqrt(number);

        // 에라토스테네스의 체에 따라 limit까지 배수 여부를 구한다.
        for (int i = 2; i <= limit; i++) {
            if (number % i == 0) return false;
        }

        return true;
    }

    public void recursive(String comb, String others) {
        // 현재 조합을 set에 추가한다.
        if (!comb.equals("")) set.add(Integer.valueOf(comb));

        // 남은 숫자 중 한 개를 더해 새로운 조합을 만든다.
        for (int i = 0; i < others.length(); i++)
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
    }

    public int solution(String numbers) {
        int answer = 0; // 소수의 개수를 셀 answer;

        // 모든 조합의 숫자를 만든다.
        recursive("", numbers);

        // 소수의 개수만 센다.
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int number = it.next();
            if (isPrime(number)) answer++;
        }

        // 소수의 개수를 반환한다.
        return answer;
    }
}