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
            int N = sc.nextInt();
            
            int[][] map = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            
            int[][] dp = new int[N][N];
            int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
			
            int maxLen = -1;
            int startNum = Integer.MAX_VALUE;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                	int length = dfs(i, j, map, dp, dir);
                    
                    if(maxLen < length || (maxLen == length && map[i][j] < startNum)) {
                        maxLen = length;
                        startNum = map[i][j];
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + startNum + " " + maxLen);
		}
	}
    
    private static int dfs(int x, int y, int[][] map, int[][] dp, int[][] dir) {
        if(dp[x][y] != 0) return dp[x][y];
        
        dp[x][y] = 1;
        for(int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            
            if(nx > -1 && nx < dp.length && ny > -1 && ny < dp[0].length) {
                if(map[nx][ny] == map[x][y] + 1) {
                    dp[x][y] = Math.max(dp[x][y], dfs(nx, ny, map, dp, dir) + 1);
                }
            }
        }
        
        return dp[x][y];
    }
}