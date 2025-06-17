import java.util.*;

class Solution {
    char[] result;
    String[] orderList;
    
    List<String> answer = new ArrayList<>();

    // Key : 코스 조합, Value : 해당 코스가 등장한 횟수 
    Map<String, Integer> menuCnt = new HashMap<>();

    // Key : 코스 요리 개수, Value : 해당 개수의 코스 중 가장 많이 등장한 횟수
    Map<Integer, Integer> maxCnt = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        orderList = orders;
        
        // 주문 목록의 각 주문을 알파벳 순으로 정렬 ( WX, XW 의 경우에는 다른 코스로 간주되므로 )
        for(int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }
        
        // 주어진 course의 각 코스 개수에 대해 조합을 생성
        for(String o : orders) {
            for(int c : course) {
                if(o.length() >= c) {
                    result = new char[c]; // 조합 결과를 저장할 배열 초기화
                    combi(0, 0, c, o);
                }
            }
        }
        
        // 생성된 코스 조합 중, 조건에 맞는 코스를 결과에 추가 
        for(Map.Entry<String, Integer> entry : menuCnt.entrySet()) {
            // 코스가 2번 이상 주문되었고, 해당 코스의 개수가 최대값과 같을 경우 answer에 추가 
            if(entry.getValue() >= 2 && maxCnt.get(entry.getKey().length()) == entry.getValue()) {
                answer.add(entry.getKey());
            }
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    
    private void combi(int depth, int index, int cnt, String target) {
        if(depth == cnt) {
            String combiResult = new String(result);

            // 해당 조합의 등장 횟수 업데이트
            menuCnt.put(combiResult, menuCnt.getOrDefault(combiResult, 0) + 1);
            
            // 현재 조합의 길이에 따라 최대 등장 횟수 갱신 
            if(maxCnt.getOrDefault(combiResult.length(), 0) < menuCnt.get(combiResult)) {
                maxCnt.put(combiResult.length(), menuCnt.get(combiResult));
            }
            
            return;
        }
        
        for(int i = index; i < target.length(); i++) {
            result[depth] = target.charAt(i);
            combi(depth + 1, i + 1, cnt, target);
        }
    }
}