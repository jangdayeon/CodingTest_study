import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        List<boolean[]> resultCombi = new ArrayList<>();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = i+1;
        }
        combination(0, new boolean[n], 0, nums, resultCombi);
        
        for(boolean[] b : resultCombi){
            if(isSecurityCode(b, q, ans)) answer++;
        }
        return answer;
    }
    private void combination(int cnt, boolean[] visited, int r, int[] nums, List<boolean[]> resultCombi){
        if(cnt == 5){
            resultCombi.add(visited.clone());
            return;
        }
        if(r==nums.length) return;
        visited[r] = true;
        combination(cnt+1, visited, r+1, nums, resultCombi);
        visited[r] = false;
        combination(cnt,visited, r+1, nums, resultCombi);
    }
    
    private boolean isSecurityCode(boolean[] code, int[][] q, int[] ans){
        int rtn = 0;
        for(int i=0; i<q.length; i++){
            int nowAns = 0;
            for(int j=0; j<q[0].length; j++){
                if(code[q[i][j]-1]) nowAns++; 
            }
            
            if(nowAns!=ans[i]) return false;
        }
        return true;
    } 
}