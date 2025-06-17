//짝수일 경우 + 1한 값 리턴
//홀수일 경우 -> 2진수로 변환된 값에서 가장 뒤에 있는 0의 위치를 찾고, 그것을 1로 바꾼다음 0의 위치 바로 뒤에 있는 값을 0으로 바꾼다.
import java.lang.*;
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0;i<numbers.length;i++){
            long n = numbers[i];
            if(n % 2 == 0){ //짝수일 경우
                answer[i] = n+1;
            } else {
                String binary = Long.toBinaryString(n);
                if(binary.indexOf("0")==-1){
                    binary = "10"+binary.substring(1);
                } else { 
                    int zero_idx = binary.lastIndexOf('0');
                    int one_idx = zero_idx+1;

                    StringBuilder sb = new StringBuilder(binary);
                    sb.setCharAt(one_idx, '0');
                    sb.setCharAt(zero_idx, '1');
                    binary = sb.toString();
                }
                answer[i] = Long.parseLong(binary,2);    
            }
        }
        return answer;
    }
}