//작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순으로 우선순위
import java.util.*;

class Solution {
    private class Work implements Comparable<Work>{
        int i;
        int s;
        int l;
        public Work(int i, int s, int l){
            this.i = i;
            this.s = s;
            this.l = l;
        }
    @Override
    public int compareTo(Work w) {
       if (this.l != w.l) { // 1차: 소요시간 짧은 순
            return this.l - w.l;
       } else if (this.s != w.s) { // 2차: 요청 시각 빠른 순
            return this.s - w.s;
       } else { // 3차: 작업 번호 작은 순
            return this.i - w.i;
       }
}

    }
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, 
                    Comparator.comparingInt((int[] a) -> a[0])  // 1차: a[0] 기준
                        .thenComparingInt(a -> a[1])      // 2차: a[1] 기준
        );
        
        int jIdx = 0;
        PriorityQueue<Work> q = new PriorityQueue<>();
        
        int nowTime = jobs[0][0];
        while(!q.isEmpty() || jIdx < jobs.length){ //뒤에 조건은 작업간의 텀이 있을 수 있어서
            if(q.isEmpty()){
                nowTime = jobs[jIdx][0];
                q.add(new Work(jIdx, jobs[jIdx][0], jobs[jIdx][1]));
                jIdx++;
            }
            Work now = q.remove();
            nowTime += now.l;
            answer += nowTime - now.s;
            while(jIdx < jobs.length && jobs[jIdx][0] <= nowTime){
                q.add(new Work(jIdx, jobs[jIdx][0], jobs[jIdx][1]));
                jIdx++;
            }
        }
        
        return answer / jobs.length;
    }
}