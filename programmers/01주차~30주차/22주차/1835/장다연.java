import java.util.*;

class Solution {
    private char[] dft = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private char[] rst = new char[8];
    private boolean[] visited = new boolean[8];
    private int answer = 0;
    public int solution(int n, String[] data) {
        permutation(0, 8, data);
        return answer;
    }
    
    private void permutation(int r, int dept, String[] data){
        if(r==dept){
            if(checkTheRequirement(data)) answer++;
            return;
        }
        
        for(int i=0; i<8; i++){
            if(!visited[i]){
                visited[i] = true;
                rst[r] = dft[i];
                permutation(r+1, dept, data);
                visited[i] = false;
                rst[r] = '-';
            }
        }
    }
    
    private boolean checkTheRequirement(String[] data){
        for(int i=0; i<data.length; i++){
            char[] d = data[i].toCharArray();
            int idx1 = -1, idx2 = -1;
            for(int j=0; j<8; j++){
                if(rst[j] == d[0]) idx1 = j;
                if(rst[j] == d[2]) idx2 = j;
            }
            int gap = Math.abs(idx2-idx1) -1;
            int comparing = d[4]-48;
            switch(d[3]){
                case '=' -> {if(gap != comparing) return false;}
                case '<' -> {if(gap >= comparing) return false;}
                case '>' -> {if(gap <= comparing) return false;}
            }
        }
        return true;
    }
}