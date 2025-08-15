import java.util.*;

class Solution {
    class Disk {
        int jobNumber;
        int startTime;
        int takeTime;
        
        public Disk(int jobNumber, int startTime, int takeTime) {
            this.jobNumber = jobNumber;
            this.startTime = startTime;
            this.takeTime = takeTime;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<Disk> pq = new PriorityQueue<>((d1, d2) -> {
            if(d1.takeTime != d2.takeTime) return Integer.compare(d1.takeTime, d2.takeTime);
            if(d1.startTime != d2.startTime) return Integer.compare(d1.startTime, d2.startTime);
            return Integer.compare(d1.jobNumber, d2.jobNumber);
        });
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        int time = 0, done = 0, idx = 0;
        while(done < jobs.length) {
            while(idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(new Disk(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if(!pq.isEmpty()) {
                Disk d = pq.poll();
                time += d.takeTime;
                answer += (time - d.startTime);
                done++;
            } else {
                time = Math.max(time, jobs[idx][0]);
            }
        }
        
        return answer / jobs.length;
    }
}