class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int walletMax = Integer.MIN_VALUE;  // -2 147 483 648
        int walletMin = Integer.MAX_VALUE;  // +2 147 483 647
        int billMax = Integer.MIN_VALUE;
        int billMin = Integer.MAX_VALUE;

        for (int i = 0; i < 2; i++) {
            if(walletMax < wallet[i]) walletMax = wallet[i];
            if(walletMin > wallet[i]) walletMin = wallet[i];
            if(billMax < bill[i]) billMax = bill[i];
            if(billMin > bill[i]) billMin = bill[i];
        }
        while (true) {
            if (billMin > walletMin || billMax > walletMax) {
                billMax /= 2;
                answer++;
                if(billMax < billMin) {
                    int temp = billMax;
                    billMax = billMin;
                    billMin = temp;
                }
            } else {
                break;
            }
        }
        return answer;
    }
}