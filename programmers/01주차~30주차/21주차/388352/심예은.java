import java.util.*;

public class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int count = 0;

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) numbers.add(i);

        count = dfs(0, 0, new int[5], numbers, q, ans);

        return count;
    }

    private int dfs(int depth, int start, int[] comb, List<Integer> numbers, int[][] q, int[] ans) {
        if (depth == 5) {
            Set<Integer> secret = new HashSet<>();
            for (int num : comb) secret.add(num);

            for (int i = 0; i < q.length; i++) {
                int match = 0;
                for (int val : q[i]) {
                    if (secret.contains(val)) match++;
                }
                if (match != ans[i]) {
                    return 0;
                }
            }
            return 1;
        }

        int total = 0;
        for (int i = start; i <= numbers.size() - (5 - depth); i++) {
            comb[depth] = numbers.get(i);
            total += dfs(depth + 1, i + 1, comb, numbers, q, ans);
        }
        return total;
    }
}
