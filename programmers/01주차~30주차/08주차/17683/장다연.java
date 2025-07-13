import java.util.*;
import java.util.regex.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        m = changeCode(m);
        Arrays.sort(musicinfos, Comparator.comparingInt(p -> -findTime(p.substring(0,5),p.substring(6,11)))); // 재생시간이 긴 순으로 정렬
        for(String musicinfo : musicinfos){
            String[] musicI = musicinfo.split(",");
            musicI[3] = changeCode(musicI[3]);
            int time = findTime(musicI[0],musicI[1]);
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < time/musicI[3].length(); i++){
                sb.append(musicI[3]);
            }
            sb.append(musicI[3], 0, time % musicI[3].length());
            musicI[3] = sb.toString();
            
            if(musicI[3].contains(m)){
                return musicI[2];
            }
        }
        return "(None)";
    }
    
    public String changeCode(String m){
        char[] mToC = m.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : mToC){
            if(c<'A' || c>'z'){
                char p = sb.charAt(sb.length()-1);
                sb.deleteCharAt(sb.length()-1);
                sb.append((char) (p+10));
            } else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public int findTime(String start, String end){
        int[] s = Arrays.stream(start.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] e = Arrays.stream(end.split(":")).mapToInt(Integer::parseInt).toArray();
        return (e[0]*60+e[1])-(s[0]*60+s[1]);
    }
}