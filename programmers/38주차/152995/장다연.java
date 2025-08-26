//a[0] 별로 최소 a[1]을 저장해볼까?
//거꾸로 순회하면서 더 큰 애가 이전에 있었으면 현재값을 빼버려야 함
import java.util.*;

class Solution {
    private class Person{
        int idx;
        int firstS;
        int secondS;
        int sum;
        public Person(int idx, int firstS, int secondS){
            this.idx = idx;
            this.firstS = firstS;
            this.secondS = secondS;
            this.sum = firstS + secondS;
        }
    }
    public int solution(int[][] scores) {
        List<Person> li = new ArrayList<>();
        for(int i=0; i<scores.length; i++){
            li.add(new Person(i, scores[i][0], scores[i][1]));
        }
        Collections.sort(li, (a,b)->{
            if(a.firstS == b.firstS) return b.secondS - a.secondS;
            else return a.firstS - b.firstS;
        });
        
        int secondMax = li.get(li.size()-1).secondS;
        for(int i=li.size()-2; i>=0; i--){
            Person now = li.get(i);
            if(now.secondS < secondMax) li.remove(i);
            else secondMax = Math.max(secondMax, now.secondS);
        }

        Collections.sort(li, (a,b)->{
            return b.sum - a.sum;
        });
        
        int answer = -1;
        //동석차 처리 필요
        int rank = 1;
        for(int i=0; i<li.size(); i++){
            while(i>0 && i<li.size() && li.get(i-1).sum == li.get(i).sum){
                if(li.get(i).idx==0) answer = rank;
                i++;
            }
            rank = i+1;
            if(i<li.size() && li.get(i).idx==0) answer = rank;
        }
        return answer;
    }
}