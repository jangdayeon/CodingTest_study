import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int[][] fatigue = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        int totalPicks = picks[0] + picks[1] + picks[2];
        int maxGroups = Math.min(totalPicks, (minerals.length + 4) / 5);

        List<int[]> mineralGroups = new ArrayList<>();

        // 광물을 5개씩 그룹화
        for (int i = 0; i < maxGroups; i++) {
            int[] count = new int[3]; // {diamond, iron, stone} 개수
            for (int j = 0; j < 5 && i * 5 + j < minerals.length; j++) {
                count[mineralToIndex(minerals[i * 5 + j])]++;
            }
            mineralGroups.add(count);
        }

        // 다이아몬드 개수를 기준으로 정렬 (그리디 전략)
        mineralGroups.sort((a, b) -> b[0] != a[0] ? b[0] - a[0] : (b[1] != a[1] ? b[1] - a[1] : b[2] - a[2]));

        // 최소 피로도 계산
        int fatigueSum = 0, pickIndex = 0;
        for (int[] group : mineralGroups) {
            while (pickIndex < 3 && picks[pickIndex] == 0) pickIndex++;
            if (pickIndex >= 3) break;

            for (int i = 0; i < 3; i++) fatigueSum += group[i] * fatigue[pickIndex][i];
            picks[pickIndex]--;
        }

        return fatigueSum;
    }

    private int mineralToIndex(String mineral) {
        return mineral.equals("diamond") ? 0 : mineral.equals("iron") ? 1 : 2;
    }
}