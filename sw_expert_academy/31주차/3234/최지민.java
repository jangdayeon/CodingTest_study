import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
    static int count = 0;
  
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            
            int[] weight = new int[N];
            for(int i = 0; i < N; i++) {
                weight[i] = sc.nextInt();
            }
            
            List<int[]> cases = new ArrayList<>();
			permutation(cases, weight, new int[N], new boolean[N], 0, N);
            
            for(int i = 0; i < cases.size(); i++) {
                weightCase(cases.get(i), 0, 0, 0);
            }
            
            System.out.println("#" + test_case + " " + count);
            count = 0;
		}
	}
    
    private static void permutation(List<int[]> cases, int[] arr, int[] result, boolean[] visited, int depth, int n) {
        if(depth == n) {
            cases.add(result.clone());
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                permutation(cases, arr, result, visited, depth + 1, n);
                visited[i] = false;
            }
        }
    }
    
    private static void weightCase(int[] arr, int index, int left, int right) {
        if(right > left) return;
        
        if(index == arr.length) {
            if(left >= right) count++;
            return;
        }
        
        weightCase(arr, index + 1, left + arr[index], right);
        weightCase(arr, index + 1, left, right + arr[index]);
    }
}