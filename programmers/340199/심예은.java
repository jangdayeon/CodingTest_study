class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (true) {
            // 지갑 50 * 50, 지폐 100 * 241
            // 지갑의 크기보다 지폐의 크기가 작은지, 큰지 확인
            // 지갑과 지폐 배열의 최소값, 최댓값을 각각 구하기
            int wallet_min = Integer.MIN_VALUE;
            int wallet_max = Integer.MIN_VALUE;

            for (int number : wallet) {
                if (number < wallet_min) wallet_min = number; // 50
                if (number > wallet_max) wallet_max = number; // 50
            }

            int bill_min = Integer.MAX_VALUE;
            int bill_max = Integer.MIN_VALUE;

            for (int number : bill) {
                if (number < bill_min) bill_min = number; // 100, 100, 60, 50, 30
                if (number > bill_max) bill_max = number; // 241, 120, 100, 60, 50
            }

            // 100 > 50 || 241 > 50, 100 > 50 || 120 > 50, 60 > 50 || 100 > 50, 50 > 50 || 60 > 50, 30 > 50 || 50 > 50
            if(bill_min > wallet_min || bill_max > wallet_max) {
                // 지폐 반으로 접기
                if (bill[0] > bill[1]) { // 100 > 241, 120 > 100, 60 > 100, 50 > 60
                    bill[0] /= 2; // 60
                } else {
                    bill[1] /= 2; // 120, 50, 30
                }

                // 90도 돌리기
                int temp = 0;
                temp = bill[0];
                bill[0] = bill[1]; // 120, 100, 50, 30
                bill[1] = temp; // 100, 60, 60, 50

                // 접는 횟수 증가
                answer++; // 1, 2, 3, 4
            } else {
                break;
            }
        }
        return answer;
    }
}
