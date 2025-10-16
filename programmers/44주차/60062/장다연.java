import java.util.*;
class Solution {
    List<int[]> order = new ArrayList<>();
    public int solution(int n, int[] weak, int[] dist) {
        int answer = Integer.MAX_VALUE;
        //1. 원을 일자로 펴기
        int[] extendedWeak = new int[weak.length*2];
        for(int i=0; i<weak.length; i++){
            extendedWeak[i] = weak[i];
            extendedWeak[i+weak.length] = n + weak[i];
        }
        // System.out.println(Arrays.toString(extendedWeak));
        
        //2. 친구 순서 정하기(순열 만들기)
        permutation(dist, 0, dist.length, new int[dist.length], new boolean[dist.length]);
        // for(int[] o : order){
        //     System.out.print(Arrays.toString(o));        
        // }
        
        //3.각 시작점에서 점검하기
        for(int start=0; start<weak.length; start++){
            for(int[] friends : order){
                int cnt = 1;
                int endPoint = extendedWeak[start] + friends[0];
                boolean success = true;
                for(int now=start; now<start+weak.length; now++){
                    if(extendedWeak[now] > endPoint){
                        cnt++;
                        if(cnt > dist.length) {
                            success = false;
                            break;
                        }
                        endPoint = extendedWeak[now] + friends[cnt-1];
                    }
                }
                if(success) answer = Math.min(answer, cnt);
            }
        }
        return answer == Integer.MAX_VALUE? -1 : answer;
    }
    private void permutation(int[] dist, int r, int n, int[] o, boolean[] visited){
        if(r==n){
            order.add(o.clone());
            return;
        }
        for(int i=0; i<n; i++){
            if(!visited[i]) {
                o[r] = dist[i];
                visited[i] = true;
                permutation(dist, r+1, n, o, visited);
                visited[i] = false;
            }
        }
    }
}