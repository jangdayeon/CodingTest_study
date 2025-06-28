import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int M = sc.nextInt();
            
            HashMap<Integer, Set<Integer>> map = new HashMap<>();
            for(int i = 0; i < M; i++) {
                int one = sc.nextInt();
                int two = sc.nextInt();
                
                map.computeIfAbsent(one, k -> new HashSet<>()).add(two);
                map.computeIfAbsent(two, k -> new HashSet<>()).add(one);
            }
            
           	boolean[] visited = new boolean[N + 1];
            int answer = 0;
            for(int i = 1; i <= N; i++) {
                if(!visited[i]) {
            		Deque<Integer> deque = new ArrayDeque<>();
            		deque.add(i);
                    visited[i] = true;
            
            		while(!deque.isEmpty()) {
                		int x = deque.poll();
                		if(map.containsKey(x)) {
                    		for(int y : map.get(x)) {
                    			if(!visited[y]) {
                        			visited[y] = true;
                        			deque.add(y);
                    			}
                			}
                		}
            		}
                    
                    answer++;
                }
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}