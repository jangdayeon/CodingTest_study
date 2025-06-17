// 모든 할인율 조합을 다 구하자

import java.util.*;

class Solution {
    static int[] ratios = { 10, 20, 30, 40 }; //할인율
    static int[] output;
	static List<int[]> outputs = new ArrayList<>(); //할인율 중복순열 결과 저장
    static int[] answer = new int[2]; //가입 수, 매출 액
    
    public int[] solution(int[][] users, int[] emoticons) {
        output = new int[emoticons.length];
        
        repeatPermutation(0,ratios.length,emoticons.length);
        
        for(int[] o : outputs){
            int sub = 0; //가입수
            int sales = 0;//매출액
            for(int[] user : users){
                double sum =0;
                for(int i=0;i<emoticons.length;i++){
                    if(o[i] < user[0]) continue; //유저가 원하는 할인율보다 낮을 땐 구매X
                    sum += calculateRatio(o[i],emoticons[i]);
                }
                if(sum >= user[1]) { //이모티콘 플러스 가입 조건 성립할 경우
                    sub += 1;
                } else {
                    sales += (int) sum;
                    
                }
            }
            
            if(answer[0] < sub){
                answer[0] = sub;
                answer[1] = sales;
            } else if (answer[0] == sub && answer[1] < sales) {
                answer[0] = sub;
                answer[1] = sales;
            }
        }
        return answer;
    }
    
    // 중복순열
	static void repeatPermutation(int depth, int n, int r) {
		// 순열이 완성된 경우
		if (depth == r) {
            outputs.add(output.clone());
			return;
		}
	
		// 0부터 n까지 반복
		for (int i = 0; i < n; i++) {
			output[depth] = ratios[i]; // 현재 depth를 인덱스로 사용
			repeatPermutation(depth + 1, n, r); // depth + 1를 전달
		}
	}
    
    static double calculateRatio(int ratio, int before){
        return before * ( (double) (100-ratio)/100 );
    }
}