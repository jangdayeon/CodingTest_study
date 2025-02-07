import java.util.*;

public class Solution19 {
    public int solution(int[] elements) {
        HashSet<Integer> sumSet = new HashSet<>();
        int n = elements.length;

        for (int size = 1; size <= n; size++) {
            for (int startPoint = 0; startPoint < n; startPoint++) {
                int sum = 0;

                for (int i = 0; i < size; i++) {
                    sum += elements[(startPoint + i) % n];
                }
                sumSet.add(sum);
            }
        }
        return sumSet.size();
    }
}
