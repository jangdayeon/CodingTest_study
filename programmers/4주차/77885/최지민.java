import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            
            char[] binaryArr = Long.toBinaryString(num).toCharArray();
            boolean flag = false;
            
            for(int j = binaryArr.length - 1; j > -1; j--) {
                if(binaryArr[j] == '0') {
                    binaryArr[j] = '1';
                    
                    if(j < binaryArr.length - 1) {
                        binaryArr[j + 1] = '0';
                    }
                    flag = true;
                    break;
                }
            }
            
            String result;
            if(!flag) {
                result = "10" + new String(binaryArr).substring(1);
            } else {
                result = new String(binaryArr);
            }
            
            answer[i] = Long.parseLong(result, 2);
        }
        
        return answer;
    }
}