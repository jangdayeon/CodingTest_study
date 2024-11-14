import java.util.Arrays;


class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        
        int result = -1; 

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length; j++) {
                if (park[i][j].equals("-1")) {
                    int width = checkWidth(mats,park, new int[]{i, j});
                    result = result > width ? result : width ;
}
            }
        }

        return result; 
    }
    
    private int checkWidth(int[] mats, String[][] park, int[] start){
        for(int ii=mats.length-1;ii>-1;ii--) {
            int m = mats[ii];
            if ( start[0]+m > park.length || start[1]+m > park[0].length) continue;
            boolean flag = false;
            label:
            for (int i = start[0]; i < start[0]+m ; i++) {
                for (int j = start[1]; j < start[1]+m ; j++) {
                    if (!park[i][j].equals("-1")) { 
                        flag = true;
                        continue label;
                    }
                }
            }
            if (flag  != true ) return m;
        }
        return -1;
    }
}