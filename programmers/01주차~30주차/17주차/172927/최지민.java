import java.util.*;

class Mineral {
    int diamond;
    int iron;
    int stone;
}

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int[][] picksP = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        
        List<Mineral> fiveSort = new ArrayList<>();
        
        int totalPicks = picks[0] + picks[1] + picks[2];
        
        for(int i = 0; i < minerals.length && fiveSort.size() < totalPicks; i += 5) {
            Mineral m = new Mineral();
            
            for(int j = i; j < i + 5 && j < minerals.length; j++) {
                switch(minerals[j]) {
                    case "diamond" -> m.diamond += 1;
                    case "iron" -> m.iron += 1;
                    case "stone" -> m.stone += 1;
                }
            }
            
            fiveSort.add(m);
        }
        
        Collections.sort(fiveSort, (a, b) -> b.diamond == a.diamond ? b.iron - a.iron : b.diamond - a.diamond);
        
        for(Mineral m : fiveSort) {
            for(int i = 0; i < 3; i++) {
                if(picks[i] >= 1) {
                    answer += picksP[i][0] * m.diamond + picksP[i][1] * m.iron + picksP[i][2] * m.stone;
                    picks[i]--;
                    break;
                }
            }
        }
        
        return answer;
    }
}