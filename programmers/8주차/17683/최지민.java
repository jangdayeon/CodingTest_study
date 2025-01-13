import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        List<String[]> answer = new ArrayList<>();
        
        for(String music : musicinfos) {
            String[] info = music.split(",");
            
            int totalTime = timeToM(info[1]) - timeToM(info[0]);
            
            String newM = delHashTag(m);
            String newMInfo = delHashTag(info[3]);
            
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < totalTime; i++) {
                sb.append(newMInfo.charAt(i % newMInfo.length()));
            }
            
            if(sb.toString().contains(newM)) {
                answer.add(new String[]{info[2], String.valueOf(totalTime)});
            }
        }
        
        if(answer.isEmpty()) return "(None)";
        
        Collections.sort(answer, (a1, a2) -> Integer.valueOf(a2[1]) - Integer.valueOf(a1[1]));
        
        return answer.get(0)[0];
    }
    
    private int timeToM(String time) {
        String[] t = time.split(":");
        return (Integer.valueOf(t[0]) * 60) + (Integer.valueOf(t[1]));
    }
    
    private String delHashTag(String music) {
        return music.replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f").replaceAll("G#", "g").replaceAll("A#", "a").replaceAll("B#", "b");
    }
}