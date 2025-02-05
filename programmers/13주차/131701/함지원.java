import java.util.*;

public class Solution {
    public int solution(int[] elements) {
        int[] circleElements = new int[elements.length * 2];
        HashSet<Integer> sumSet = new HashSet<>();

        for (int i = 0; i < elements.length * 2; i++) circleElements[i] = elements[i % elements.length];

        for (int size = 1; size <= elements.length; size++) {
            for (int startPoint = 0; startPoint < elements.length; startPoint++) {
                int answer = 0;

                for (int i = 0; i < size; i++) {
                    answer += circleElements[startPoint + i];
                }
                sumSet.add(answer);
            }
        }

        return sumSet.size();
    }
}