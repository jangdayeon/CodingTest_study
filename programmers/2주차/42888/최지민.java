import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        
        Map<String, String> map = new HashMap<>();
        
        for(String r : record) {
            String[] splitR = r.split(" ");
            
            if(splitR[0].equals("Enter") || splitR[0].equals("Change")) {
                map.put(splitR[1], splitR[2]);
            }
        }
        
        for(int i = 0; i < record.length; i++) {
            String[] splitR = record[i].split(" ");
            
            if(splitR[0].equals("Enter")) {
                answer.add(map.get(splitR[1]) + "님이 들어왔습니다.");
            } else if(splitR[0].equals("Leave")) {
                answer.add(map.get(splitR[1]) + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}