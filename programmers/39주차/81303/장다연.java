//답 확인함

import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        boolean[] removed = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int pointer = k;

        for (String c : cmd) {
            char op = c.charAt(0);
            if (op == 'U') {
                int x = Integer.parseInt(c.substring(2));
                for (int i = 0; i < x; i++) {
                    pointer = prev[pointer];
                }
            } else if (op == 'D') {
                int x = Integer.parseInt(c.substring(2));
                for (int i = 0; i < x; i++) {
                    pointer = next[pointer];
                }
            } else if (op == 'C') {
                stack.push(pointer);
                removed[pointer] = true;

                if (prev[pointer] != -1) next[prev[pointer]] = next[pointer];
                if (next[pointer] != -1) prev[next[pointer]] = prev[pointer];

                if (next[pointer] != -1) pointer = next[pointer];
                else pointer = prev[pointer];
            } else if (op == 'Z') {
                int restore = stack.pop();
                removed[restore] = false;

                if (prev[restore] != -1) next[prev[restore]] = restore;
                if (next[restore] != -1) prev[next[restore]] = restore;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(removed[i] ? 'X' : 'O');
        }
        return sb.toString();
    }
}
