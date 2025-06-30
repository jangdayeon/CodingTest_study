import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		sc.nextLine();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] nm = sc.nextLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            char[][] flag = new char[n][m];
             int[] whiteCnt = new int[n];
             int[] redCnt = new int[n];
             int[] blueCnt = new int[n];

            for(int i=0; i<n; i++){
            	flag[i] = sc.nextLine().toCharArray();
                whiteCnt[i] = cntColor('W', flag[i]);
                redCnt[i] = cntColor('R', flag[i]);
                blueCnt[i] = cntColor('B', flag[i]);
            }
            
            int min = getMinValue(whiteCnt, redCnt, blueCnt, n, m);
            System.out.println("#"+test_case+" "+min);
		}
	}
    	private static int getMinValue(int[] whiteCnt, int[] redCnt, int[] blueCnt, int n, int m){
            int answer = 2501;
        	int frontAndBackMustChangeColorCnt = 0;
            frontAndBackMustChangeColorCnt += m-whiteCnt[0];
            frontAndBackMustChangeColorCnt += m-redCnt[n-1];
            int restLine = n-2;
            
            for(int i=0; i<restLine; i++){
                for(int j=restLine-i; j>=1; j--){
                    int z = restLine-i-j;
                    //i=white, j=blue, z=red 줄의 개수
                    //System.out.println(i+" "+j+" "+z);
                    int mustChangeColorCnt = frontAndBackMustChangeColorCnt;
                    int idx = 1;
                    for(int k=idx; k<idx+i; k++){
                        mustChangeColorCnt+=m-whiteCnt[k];
                    }
                    idx +=i;
                    for(int k=idx; k<idx+j; k++){
                        mustChangeColorCnt+=m-blueCnt[k];
                    }
                    idx +=j;
                    for(int k=idx; k<idx+z; k++){
                        mustChangeColorCnt+=m-redCnt[k];
                    }
                    idx +=z;
                    answer = Math.min(answer, mustChangeColorCnt);
                }
            }
            return answer;
        }
         private static int cntColor(char c, char[] arr){
             int answer = 0;
             for(int i=0; i<arr.length; i++){
                 if(arr[i] == c) answer++;
             }
            return answer;
        }
}