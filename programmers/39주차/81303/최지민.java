import java.util.LinkedList;
import java.util.*;

class Solution {

    public String solution(int n, int k, String[] cmd) {
        String answer = "";

        int tablesize = n;
        Deque<Integer> st = new ArrayDeque<>();

        for (String command : cmd) {
            char c = command.charAt(0);
            
            if (c == 'U') {
                k -= Integer.parseInt(command.substring(2));
                if (k < 0) k = 0;
            } else if (c == 'D') {
                k += Integer.parseInt(command.substring(2));
                if (k > tablesize - 1) k = tablesize - 1;
            } else if (c == 'C') {
                st.push(k);
                tablesize--;
                if(k == tablesize) k--;
            } else {
                int ret = st.pop();
                if(k>=ret) k++;
                tablesize++;
            }
        }

        char[] result = new char[n];  // n이 아닌 tablesize
Arrays.fill(result, 'O');
Integer[] stackArray = st.toArray(new Integer[0]);
// 뒤에서부터 처리
for(int i = stackArray.length - 1; i >= 0; i--) {
    result[stackArray[i]] = 'X';
}
        
        return new String(result);
    }
}