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
            int N = sc.nextInt();
            String cal = sc.next();
            
            Deque<Character> stack = new ArrayDeque<>();
            List<Character> list = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                Character c = cal.charAt(i);
                if(Character.isDigit(c)) {
                    list.add(c);
                } else {
                    if(stack.isEmpty()) {
                        stack.add(c);
                    } else {
						if(c == '(') {
                        	stack.add('(');
                        } else if(c == ')') {
                            while(!stack.isEmpty() && stack.peekLast() != '(') {
                                list.add(stack.removeLast());
                            }
                            stack.removeLast();
                        } else {
                            while(!stack.isEmpty() && priority(stack.peekLast()) >= priority(c)) {
                                list.add(stack.removeLast());
                            }
                            stack.add(c);
                        }
                    }
                }
            }
            
            while(!stack.isEmpty()) {
                list.add(stack.removeLast());
            }
			
            Deque<Integer> calc = new ArrayDeque<>();
            for(int i = 0; i < list.size(); i++) {
                Character c = list.get(i);
                
                if(Character.isDigit(c)) {
                    calc.add(c - '0');
                } else {
                    if(calc.size() >= 2) {
                        int a = calc.removeLast();
                        int b = calc.removeLast();
                        
                        if(c == '+') {
                            calc.add(a + b);
                        } else {
                            calc.add(a * b);
                        }
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + calc.peek());
		}
	}
    
    private static int priority(char p) {
        switch(p) {
            case '+':
                return 1;
            case '*':
                return 2;                
        }
        
         return 0;
    }
}