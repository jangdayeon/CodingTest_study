import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
		    int T=sc.nextInt();
        	sc.nextLine();
            
            int x = 99, y = 0;
            int[][] map = new int[100][100];
            for(int i = 0; i < 100; i++) {
                map[i] = Arrays.stream(sc.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            
            for(int j = 0; j < 100; j++) {
                    if(map[99][j] == 2) {
                        y = j;
                   		break;
                    }
            }
            
            while(x > 0) {
                if(y > 0 && map[x][y - 1] == 1) {
                    while(y > 0 && map[x][y - 1] == 1) {
                        y--;
                    }
                } else if(y < 99 && map[x][y + 1] == 1) {
                    while(y < 99 && map[x][y + 1] == 1) {
                        y++;
                    }
                } 
                
                x--;
            }
			
            System.out.println("#" + test_case + " " + y);
            
		}
	}
}