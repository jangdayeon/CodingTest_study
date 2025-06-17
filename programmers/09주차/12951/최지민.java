import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.toLowerCase().split(" ", -1);
        StringBuilder sb = new StringBuilder("");
        
        for(int i = 0; i < arr.length; i++) {
            if(!arr[i].isEmpty()) {
                if(arr[i].charAt(0) >= 'a' && arr[i].charAt(0) <= 'z') {
                    sb.append((char)(arr[i].charAt(0) - ('a' - 'A')));
                    sb.append(arr[i].substring(1));
                } else {
                    sb.append(arr[i]);
                }
            }
            
            if(i < arr.length - 1) {
                sb.append(" ");
            }
        }
    
        return sb.toString();
    }
}