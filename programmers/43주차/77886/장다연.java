import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for(int i=0; i<s.length; i++){
            answer[i] = findAnswer(s[i]);
        }
        return answer;
    }
    private String findAnswer(String s){
        Deque<Character> answer = new ArrayDeque<>();
        Deque<Character> stack = new ArrayDeque<>();
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            stack.addLast(s.charAt(i));
            if(stack.size() >= 3){
                char a = stack.removeLast();
                char b = stack.removeLast();
                char c = stack.removeLast();
                if(a=='0' && b=='1' && c=='1'){
                    cnt++;
                } else {
                    stack.addLast(c);
                    stack.addLast(b);
                    stack.addLast(a);
                }
            }
        }        
        while(stack.size() > 0){
            char now = stack.removeLast();
            if(now=='0') {
                while(cnt-->0){
                    answer.addFirst('0');
                    answer.addFirst('1');
                    answer.addFirst('1');
                }
            }
            answer.addFirst(now);
        }
        while(cnt-->0){
            answer.addFirst('0');
            answer.addFirst('1');
            answer.addFirst('1');
        }
        StringBuilder sb = new StringBuilder();
        for(char c : answer) sb.append(c);
        return sb.toString();
    }
}