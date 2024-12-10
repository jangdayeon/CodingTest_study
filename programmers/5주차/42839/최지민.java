import java.util.*;

class Solution {
    HashSet<Integer> hash = new HashSet<>();
    char[] numberArr;
    
    public int solution(String numbers) {
        int answer = 0;
        
        this.numberArr = numbers.toCharArray();
        
        for(int i = 1; i <= numbers.length(); i++) {
            permutation(0, i, "", new boolean[numberArr.length]);
        }
        
        return hash.size();
    }
    
    private void permutation(int depth, int end, String result, boolean[] visited) {
        if(depth == end) {
            int num = Integer.parseInt(new String(result));
            
            if(checkPrime(num)) {
                hash.add(num);
            }
            return;
        }
        
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                permutation(depth + 1, end, result + numberArr[i], visited);
                visited[i] = false;
            }
        }
    }
    
    private boolean checkPrime(int num) {
        if(num < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}