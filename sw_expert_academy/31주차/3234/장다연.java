import java.util.*;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            int[] cnt = new int[1];
            List<int[]> permutation = new ArrayList<>();
            getPermutation(permutation, arr);
            for(int[] p : permutation){
                cntPossibleCase(cnt, p, 0, n, 0, 0);
            }
            System.out.println("#"+test_case+" "+cnt[0]);
        }
    }
    private static void recursive(List<int[]> p, int[] arr, int r, int dept, int[] rst, boolean[] visited){
        if(r==dept){
            p.add(Arrays.copyOf(rst, rst.length));
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                rst[r] = arr[i];
                recursive(p, arr, r+1, dept, rst, visited);
                visited[i] = false;
            }
        }
    }
    private static void getPermutation(List<int[]> p, int[] arr){
        boolean[] visited= new boolean[arr.length];
        int[] rst = new int[arr.length];
        recursive(p, arr, 0, arr.length, rst, visited);
    }
    private static void cntPossibleCase(int[] cnt, int[] arr, int r, int dept, int right, int left){
        if(r==dept){
            if(left >= right) cnt[0]++;
            return;
        }
         
        if(right+arr[r] <= left) cntPossibleCase(cnt, arr, r+1, dept, right+arr[r], left);
        if(right <= left+arr[r]) cntPossibleCase(cnt, arr, r+1, dept, right, left+arr[r]);
    }
}