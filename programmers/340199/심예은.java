import java.util.Arrays;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (true) {
            // 지갑의 크기보다 지폐의 크기가 작은지, 큰지 확인
            // 지갑과 지폐 배열의 최소값, 최댓값을 각각 구하기
            int wallet_min = Arrays.stream(wallet).min().getAsInt();
            int wallet_max = Arrays.stream(wallet).max().getAsInt();

            int bill_min = Arrays.stream(bill).min().getAsInt();
            int bill_max = Arrays.stream(bill).max().getAsInt();

            if(bill_min > wallet_min || bill_max > wallet_max) {
                // 지폐 반으로 접기
                if (bill[0] > bill[1]) {
                    bill[0] /= 2;
                } else {
                    bill[1] /= 2;
                }

                // 90도 돌리기
                int temp = 0;
                temp = bill[0];
                bill[0] = bill[1];
                bill[1] = temp;

                // 접는 횟수 증가
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}