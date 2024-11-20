import java.util.Stack;

public class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        int orderIndex = 0;

        for (int box = 1; box <= order.length; box++) {
            st.push(box);

            while (!st.isEmpty() && st.peek() == order[orderIndex]) {
                st.pop();
                answer++;
                orderIndex++;
            }
        }

        return answer;
    }
}