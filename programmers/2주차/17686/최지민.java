import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        Collections.sort(Arrays.asList(files), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1Head = o1.split("[0-9]")[0].toLowerCase();
                String o2Head = o2.split("[0-9]")[0].toLowerCase();
                
                if(o1Head.equals(o2Head)) {
                    int o1Number = Integer.parseInt(o1.split("[^0-9]+")[1]);
                    int o2Number = Integer.parseInt(o2.split("[^0-9]+")[1]);
                    
                    if(o1Number > o2Number) {
                        return 1;
                    } else if(o1Number < o2Number) {
                        return -1;
                    }
                    
                    return 0;
                } 
                return o1Head.compareTo(o2Head);
            }
        });
        
        return files;
    }
}