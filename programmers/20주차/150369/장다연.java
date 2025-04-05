class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int idx = n-1;
        long answer = 0;
        while(idx > -1){
            //뒤에서부터 실제 처리할 게 있는 곳 찾기
            while (idx >= 0 && deliveries[idx] == 0 && pickups[idx] == 0) {
                idx--;
            }
            if (idx < 0) break;
            answer += (idx + 1L) * 2;
            
            //배달
            int temp_cap = cap;
            int temp_idx1 = idx;
            
            while(temp_idx1 > -1 && temp_cap>0){
                if(deliveries[temp_idx1] == 0) {
                    temp_idx1 -= 1;
                    continue;
                }
                int delivery = deliveries[temp_idx1] < temp_cap ? deliveries[temp_idx1] : temp_cap;
                deliveries[temp_idx1] -= delivery;
                temp_cap -= delivery;
                if(deliveries[temp_idx1] == 0) temp_idx1 -= 1;
            }
            //수거
            temp_cap = cap;
            int temp_idx2 = idx;
            while(temp_idx2 > -1 && temp_cap>0){
                if(pickups[temp_idx2] == 0) {
                    temp_idx2 -= 1;
                    continue;
                }
                int pickup = pickups[temp_idx2] < temp_cap ? pickups[temp_idx2] : temp_cap;
                pickups[temp_idx2] -= pickup;
                temp_cap -= pickup;
                if(pickups[temp_idx2] == 0) temp_idx2 -= 1;
            }
            // System.out.println(answer+" "+temp_idx1+" "+temp_idx2);
            idx = Math.max(temp_idx1, temp_idx2);
        }
        return answer;
    }
}