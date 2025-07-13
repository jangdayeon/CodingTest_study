//순열로 전체 경우의 수를 구하자
//소수 구하기 방식은 두 가지
    //아리스토텔네스의 체 : 1~100 중 소수는?
    //제곱근까지 확인하고 구분 : 1은 소수인가?
import java.util.*;
import java.util.stream.*;
class Solution {
    char[] nums; //문자열 나눈 거 넣음
    Set<Integer> strs = new HashSet<>(); //pmt의 모음
    Character[] pmt;
    boolean[] visited;
    
    public int solution(String numbers) {
        nums = numbers.toCharArray();
        visited = new boolean[nums.length];
        
        int answer = 0;
        for(int i=1; i<=nums.length; i++){
            pmt = new Character[i];
            permutation(0, nums.length, i);
        }
              
        
        for (Integer s : strs) {
            if (s >= 2 && isSosu(s)) {
                answer++;
            }
        }
        
        return answer;
    }
    public boolean isSosu(Integer s){
        for(int i =2;i<= (int) Math.sqrt(s);i++){
            if(s % i == 0){
                return false;
            }
        }
        return true;
    }
    
    public void permutation(int dept, int n, int r){
        if(dept == r){
            String sPmt = Stream.of(pmt)
                .map(String::valueOf) // Character를 String으로 변환
                .collect(Collectors.joining());
            strs.add(Integer.parseInt(sPmt));
            return;
        }
        for(int i=0;i<n;i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            pmt[dept] = nums[i];
            permutation(dept+1,n,r);
            visited[i] = false;
        }
    }
}
