import java.util.stream.Stream;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int totalTime = convertToSeconds(video_len);
        int posTime = convertToSeconds(pos);
        int opStartTime = convertToSeconds(op_start);
        int opEndTime = convertToSeconds(op_end);
        
        posTime = (opStartTime <= posTime && opEndTime >= posTime) ? opEndTime : posTime;
        
        for(String command: commands) {
            if(command.equals("prev")) {
                posTime -= 10;
                
                if(posTime < 0) {
                    posTime = 0;
                }
            } else {
                posTime += 10;
                
                if(posTime > totalTime) {
                    posTime = totalTime;
                }
            }
            
            posTime = (opStartTime <= posTime && opEndTime >= posTime) ? opEndTime : posTime;
            
        }
        
        answer += String.format("%02d", (posTime / 60)) + ":";
        answer += String.format("%02d", (posTime % 60));
        
        return answer;
    }
    
    private static int convertToSeconds(String time) {
        int[] timeSplit = Stream.of(time.split(":")).mapToInt(Integer::parseInt).toArray();
        return timeSplit[0] * 60 + timeSplit[1];
    }
}