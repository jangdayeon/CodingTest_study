import java.util.*;

class Solution {
    public int solution(int[] nums) {

        Set<Integer> uniqueTypes = new HashSet<>();
        for (int num : nums) {
            uniqueTypes.add(num);
        }

        int maxPick = nums.length / 2;
        int uniqueCount = uniqueTypes.size();

        return Math.min(maxPick, uniqueCount);
    }
}