import java.util.*;

class Solution {
    // 속성들의 조합을 저장하기 위한 List 생성
    List<List<Integer>> combiResult = new ArrayList<>();

    public int solution(String[][] relation) {
        // 조합을 구하기 위해 주어진 속성들의 개수대로 0부터 n까지의 배열 생성
        int[] arr = new int[relation[0].length];
        for(int i = 0; i < arr.length; i++) arr[i] = i;
        
        // 1부터 속성의 개수만큼 조합 생성
        for(int i = 1; i <= relation[0].length; i++) {
            combination(arr, 0, i, new ArrayList<>());
        }
        
        // 생성된 조합을 통해 유일성을 가지는 key를 구해 저장
        List<List<Integer>> key = new ArrayList<>();
        
        // 유일성 검사
        for (List<Integer> combi : combiResult) {
            Set<List<String>> set = new HashSet<>();
            
            for(String[] r : relation) {
                List<String> tuple = new ArrayList<>();
                
                for(int i = 0; i < combi.size(); i++) {
                    tuple.add(r[combi.get(i)]);
                }
                
                set.add(tuple);
            }

            if(set.size() == relation.length) {
                key.add(combi);
            }
        }
        
        // 크기 순으로 정렬해 최소성 검사
        Collections.sort(key, (a, b) -> a.size() - b.size());
        List<List<Integer>> finalKeys = new ArrayList<>();
        
        for(List<Integer> k : key) {
            boolean flag = true;
            for(List<Integer> fin : finalKeys) {
                if(k.containsAll(fin)) {
                    flag = false;
                    break;
                }
            }
            if(flag) finalKeys.add(k);
        }
        
        return finalKeys.size();
    }
    
    private void combination(int[] arr, int idx, int r, List<Integer> result) {
        if(result.size() == r) {
            combiResult.add(new ArrayList<>(result));
            return;
        }
        
        for(int i = idx; i < arr.length; i++) {
            result.add(arr[i]);
            combination(arr, i + 1, r, result);
            result.remove(result.size() - 1);
        }
    }
}