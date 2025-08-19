import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        char[] str = s.toCharArray();
        
        
        for(int start=0; start<str.length; start++){
            int end = str.length - 1;
            int left = start;
            int right = end;
            int length = 0;
            while(left < right){
                if(str[left] == str[right]) {
                    length+=2;
                    left++;
                    right--;
                } else {
                    length = 0;
                    left = start;
                    end--;
                    right = end;
                }
            }
            // System.out.println("현재 :"+ start + " "+length);
            answer = Math.max(answer, left == right ? length+1 : length);
        }
        return answer;
    }
}