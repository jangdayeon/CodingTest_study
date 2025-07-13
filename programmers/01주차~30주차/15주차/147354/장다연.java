import java.util.*;

//구현 문제
class Solution {
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        //1~2
        Arrays.sort(data, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[col-1] == o2[col-1] ? o2[0]-o1[0] : o1[col-1] - o2[col-1];
            }
        });
        
        //3
        Integer answer = null;
        for(int i=row_begin-1; i<=row_end-1; i++){
            int sumRest = 0;
            for(int j=0; j<data[i].length; j++){
                sumRest += data[i][j] % (i+1);
            }
            if(Objects.isNull(answer)) answer = sumRest; 
            else answer ^= sumRest;
        }
        
        return answer;
    }
}