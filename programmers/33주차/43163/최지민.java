import java.util.*;

class Word {
    String word;
    int cnt;
    
    public Word(String word, int cnt) {
        this.word = word;
        this.cnt = cnt;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean flag = true;
        for(int i = 0; i < words.length; i++) {
            if(target.equals(words[i])) flag = false;
        }
        
        if(flag) return 0;
        
        int answer = correctWord(begin, target, words, new boolean[words.length]);
        
        return answer;
    }
    
    private int correctWord(String start, String target, String[] words, boolean[] visited) {
        Deque<Word> deque = new ArrayDeque<>();
        deque.add(new Word(start, 0));
        
        while(!deque.isEmpty()) {
            Word w = deque.poll();
            String word = w.word;
            
            if(word.equals(target)) return w.cnt;
            
            for(int i = 0; i < words.length; i++) {
                if(!visited[i] && canConvert(words[i], word)) {
                    visited[i] = true;
                    deque.add(new Word(words[i], w.cnt + 1));
                }
            }
        }
        
        return 0;
    }
    
    private boolean canConvert(String w1, String w2) {
        int cnt = 0;
        
        for(int i = 0; i < w1.length(); i++) {
            if(w1.charAt(i) != w2.charAt(i)) cnt++;
            if(cnt > 1) return false;
        }
        
        return cnt == 1;
    }
}