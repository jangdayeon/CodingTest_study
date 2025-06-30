import java.util.Scanner;
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
            String str = sc.next();
            
            int result = 0;
            boolean flag = false;
            
            int left = 0;
            int right = str.length() - 1;
            while(left <= right) {
                char l = str.charAt(left);
                char r = str.charAt(right);
                
                if(l == r) {
                    left++;
                    right--;
                } else if(l == 'x') {
                    left++;
                    result++;
                } else if(r == 'x') {
                    right--;
                    result++;
                } else {
                    flag = true;
                    break;
                }
            }
            
            if(flag) {
                System.out.println(-1);
            } else {
				System.out.println(result);
            }
            
		}
	}
}