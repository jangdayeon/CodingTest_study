import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int maxLength = 0;
        
        int[][] array = new int[park.length][park[0].length];
        
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length; j++) {
                if(park[i][j].equals("-1")) {
                    array[i][j] = 1;
                }
            }
        }
        
        for(int i = 1; i < array.length; i++) {
            for(int j = 1; j < array[0].length; j++) {
                if(array[i][j] == 1) {
                    array[i][j] += Math.min(array[i - 1][j - 1], Math.min(array[i - 1][j], array[i][j - 1]));
                }
                                
                if(maxLength < array[i][j]) {
                    maxLength = array[i][j];
                }
            }            
        }
        
        if(park.length == 1) {
            maxLength = Arrays.stream(array[0]).max().getAsInt();
        }
        
        for(int mat : mats) {
            if(maxLength >= mat && answer < mat) {
                answer = mat;
            }
        }
        
        return answer;
    }
}