import java.util.*;
class Solution {
    private final char[] NAMES = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private char[] tempRst = new char[8];
    private List<String> permu = new ArrayList<>();
    public int solution(int n, String[] data) {
        int answer = 0;
        makePermutation(0, new boolean[8]);
        
        for(String p : permu){
            boolean flag = true;
            for(String d : data){
                if(!flag) break;
                char left = d.charAt(0);
                char right = d.charAt(2);
                char sign = d.charAt(3);
                int num = d.charAt(4) - '0';
                
                int leftIdx = p.indexOf(left);
                int rightIdx = p.indexOf(right);
                int distance = Math.abs(leftIdx-rightIdx)-1;
                switch(sign){
                    case '=' :
                        if(distance != num) flag = false;
                        break;
                    case '>' :
                        if(distance <= num) flag = false;
                        break;
                    case '<' :
                        if(distance >= num) flag = false;
                        break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
    private void makePermutation(int r, boolean[] visited){
        if(r == 8){
            permu.add(new String(tempRst));
            return;
        }
        for(int i=0; i<8; i++){
            if(!visited[i]){
                tempRst[r] = NAMES[i];
                visited[i] = true;
                makePermutation(r+1, visited);
                tempRst[r] = 'Z';
                visited[i] = false;
            }
        }
    }
}