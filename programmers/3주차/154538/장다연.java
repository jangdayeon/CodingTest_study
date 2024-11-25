import java.util.Arrays;

class Solution {
    public int solution(int x, int y, int n) {
        int[] arr = new int[y+1];
        Arrays.fill(arr,-1);
        arr[x] = 0;
        for(int i=x;i<y+1;i++){
            if(arr[i]==-1) continue;
            if(i+n <y+1 && (arr[i+n] == -1 || arr[i+n]>arr[i]+1)) arr[i+n] = arr[i]+1;
            if(i*2 <y+1 && (arr[i*2] == -1 || arr[i*2]>arr[i]+1)) arr[i*2] = arr[i]+1;
            if(i*3 <y+1 && (arr[i*3] == -1 || arr[i*3]>arr[i]+1)) arr[i*3] = arr[i]+1;  
        }
        return arr[y];
    }
}