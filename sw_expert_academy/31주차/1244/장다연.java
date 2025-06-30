import java.util.*;
import java.io.FileInputStream;
class Solution
{
	static char arr[];
    static int n;
    static String result;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            arr = Integer.toString(sc.nextInt()).toCharArray();
			n = sc.nextInt();
            
            result = "";
            back(0,0);
            System.out.println("#"+test_case+" "+result);
        }
	}
    private static void back(int dept, int count){
        if(count == n){
            String current = new String(arr);
            if(current.compareTo(result) > 0){
                result = current;
            }
            return;
        }
        
        for(int i=dept; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                change(i,j);
                back(i, count+1);
                change(j,i);
            }
        }
    }
    
    private static void change(int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
    