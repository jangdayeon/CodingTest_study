import java.util.*;

class Pair{
    int cur, cnt;
    Pair(int cur, int cnt){
        this.cur = cur;
        this.cnt = cnt;
    }
}

class Solution {

    public int solution(int x, int y, int n) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y,0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int cur = p.cur, cnt = p.cnt;

            if (cur < x) continue;
            if(cur == x) return cnt;

            if(cur%3==0) q.add(new Pair(cur/3,cnt+1));
            if(cur%2==0) q.add(new Pair(cur/2,cnt+1));
            q.add(new Pair(cur-n,cnt+1));

        }

        return -1;

    }

}