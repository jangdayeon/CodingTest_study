import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int boxNum = 1, index = 0;

        for (int o : order) {
            while (boxNum <= o) {
                stack.push(boxNum++);
            }
            if (stack.peek() == o) {
                stack.pop();
                index++;
            } else {
                break;
            }
        }

        return index;
    }
}
