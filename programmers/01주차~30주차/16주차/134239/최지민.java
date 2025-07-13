import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        List<Integer> graph = new ArrayList<>();
        graph.add(k);
        
        int n = 0;
        while(k != 1) {
            k = (k % 2 == 0) ? k / 2 : k * 3 + 1;
            graph.add(k);
        }
        
        for(int i = 0; i < ranges.length; i++) {
            double result = 0;
            
            if(ranges[i][0] > (graph.size() - 1 + ranges[i][1])) {
                answer[i] = -1;
                continue;
            }
            
            for(int j = ranges[i][0]; j < ((graph.size() - 1) + ranges[i][1]); j++) {
                result += (graph.get(j) + graph.get(j + 1)) * 0.5;
            }
            answer[i] = result;
        }
        
        return answer;
    }
}