//완전 잘못 생각함..ㅋㅋ 인덱스 별로 계산하려고 했더니 경우의 수가 너무 많았는데 비밀 코드 5길이 짜리 조합으로 만들고 맞는지 아닌지 걸러내면 됐던 것 ㅎ

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
            // System.out.println(Arrays.toString(b));
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
        cnt++;
        combination(cnt, visited, r+1, nums, resultCombi);
        visited[r] = false;
        cnt--;
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