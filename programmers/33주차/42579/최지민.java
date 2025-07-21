import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> genresMap = new HashMap<>();
        Map<String, Map<Integer, Integer>> playsMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
            playsMap.computeIfAbsent(genres[i], k -> new HashMap<>()).put(i, plays[i]);
        }
        
        String[] genresKey = genresMap.keySet().toArray(new String[0]);
        Arrays.sort(genresKey, (a, b) -> genresMap.get(b) - genresMap.get(a));
        
        for(int i = 0; i < genresKey.length; i++) {
            Map<Integer, Integer> playsValue = playsMap.get(genresKey[i]);
            
            Integer[] playsValueInKey = playsValue.keySet().toArray(new Integer[0]);
            Arrays.sort(playsValueInKey, (a, b) -> {
                int tmp = playsValue.get(b) - playsValue.get(a);
                if(tmp == 0) {
                    return a - b;
                }
                return tmp;
            });
            
            answer.add(playsValueInKey[0]);
            if(playsValueInKey.length >= 2) {
                answer.add(playsValueInKey[1]);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}