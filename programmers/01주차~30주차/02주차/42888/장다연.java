import java.util.stream.Stream;
import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
        String[][] splitR = new String[record.length][3];
        Map<String, String> name = new HashMap<>();
        for(int i=0; i<record.length;i++){
            splitR[i] = record[i].split(" ");
            if(!splitR[i][0].equals("Leave")){
                name.put(splitR[i][1],splitR[i][2]);
            }
        }
        
        List<String> rtn = new ArrayList<>();
        for(int i =0;i<splitR.length;i++){
            switch(splitR[i][0]){
                    case "Enter" -> rtn.add(name.get(splitR[i][1])+"님이 들어왔습니다.");
                    case "Leave" -> rtn.add(name.get(splitR[i][1])+"님이 나갔습니다.");
                    
            }
        }
        
        return rtn.toArray(String[]::new);
    }
}