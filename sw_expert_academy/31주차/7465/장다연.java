import java.util.*;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
         
            String[] nm = sc.nextLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
             
            boolean[] visited = new boolean[n+1];
            List<Set<Integer>> lines = new ArrayList<>();
            for(int i=0; i<n+1; i++){
                lines.add(new HashSet<>());
            }
            for(int i=0; i<m; i++){
                String[] line = sc.nextLine().split(" ");
                int left = Integer.parseInt(line[0]);
                int right = Integer.parseInt(line[1]);
                lines.get(left).add(right);
                lines.get(right).add(left);
            }
             
            int groupCnt = bfs(visited, lines);
            System.out.println("#"+test_case+" "+groupCnt);
        }
    }
    private static int bfs(boolean[] visited, List<Set<Integer>> lines){
        Deque<Integer> q = new ArrayDeque<>();
        int answer = 0;
        for(int i=1; i<visited.length; i++){
                if(!visited[i]){
                    q.add(i);
                    answer++;
                    while(!q.isEmpty()){
                        int now = q.remove();
                        visited[now] = true;
                        for(int s : lines.get(now)){
                            if(!visited[s]){
                                q.add(s);
                            }
                        }
                    }
                }
        }
         
        return answer;
    }
     
}