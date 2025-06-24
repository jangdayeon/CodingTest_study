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
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int answer = 0;
            int[][] color = new int[n][3];
            for(int i = 0; i < n; i++) {
                String line = sc.next();
                
                int white = 0, blue = 0, red = 0;
                for(int j = 0; j < m; j++) {
                    char c = line.charAt(j);
                    
                    if(c == 'W') color[i][0]++;
                    else if(c == 'B') color[i][1]++;
                    else color[i][2]++;
                }
            }
            
            int minSum = Integer.MAX_VALUE;
            for(int i = 0; i < n - 2; i++) {
                for(int j = i + 1; j < n - 1; j++) {
                    int sum = 0;
                    for(int w = 0; w <= i; w++) {
                        sum += (m - color[w][0]);
                    }
                    
                    for(int b = i + 1; b <= j; b++) {
                        sum += (m - color[b][1]);
                    }
                    
                    for(int r = j + 1; r < n; r++) {
                        sum += (m - color[r][2]);
                    }
                    
                    minSum = Math.min(minSum, sum);
                }
            }
            
            System.out.println("#" + test_case + " " + minSum);
		}
	}
}