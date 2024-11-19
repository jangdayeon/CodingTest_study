import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;
import java.util.Comparator;
class Solution {
    public String[] solution(String[] files) {
        List<String[]> divide = new ArrayList<>();
        
        //패턴에 맞게 split하기
        Pattern pattern = Pattern.compile("([a-zA-Z .-]+)([0-9]+)(.*)");
        for(String f : files){
            Matcher matcher = pattern.matcher(f);
    
            if (matcher.find()) {
                divide.add(new String[]{matcher.group(1),matcher.group(2),matcher.group(3)});
            }
        }
        
        //두가지 이상의 원자로 정렬하기
        
        // Collections.sort(divide, (o1,o2)-> (o2[0].toUpperCase()).compareTo(o1[0].toUpperCase()));
        // Collections.sort(divide, (o1,o2)-> Integer.parseInt(o1[1])-Integer.parseInt(o2[1]));
        
        divide.sort(
    Comparator.comparing((String[] o) -> o[0],String::compareToIgnoreCase)
              .thenComparingInt(o -> Integer.parseInt(o[1]))
);
        
        //정렬된 String[]들을 String들로 바꿔 리턴하기
        
        String[] rtn = new String[files.length];
        
        
        for(int i =0; i< rtn.length;i++){
            String[] s = divide.get(i);
            StringBuilder stringBuilder = new StringBuilder();
            rtn[i] = stringBuilder.append(s[0]+s[1]+s[2]).toString();
        }
        return rtn;
        
    }
}