import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        Character[][] arr = new Character[board[0].length()][board.length];

        for(int i = 0; i < board[0].length(); i++) {
            for(int j = 0; j < board.length; j++) {
                arr[i][j] = Character.valueOf(board[j].charAt(i));
            }
        }
        
        boolean flag = true;
        while(flag) {
            flag = false;
            
            boolean[][] checkArr = new boolean[arr.length][arr[0].length];
            
            for(int i = 0; i < arr.length - 1; i++) {
                for(int j = 0; j < arr[0].length - 1; j++) {
                    if(arr[i][j] != 'X') {
                        boolean check = checkSquare(i, j, arr);
                        
                        if(check) {
                            checkArr[i][j] = true;
                            checkArr[i + 1][j] = true;
                            checkArr[i][j + 1] = true;
                            checkArr[i + 1][j + 1] = true;
                            
                            flag = true;
                        }
                    }
                }
            }
            
            if(!flag) break;
            
            answer += blockDown(arr, checkArr);
        }
        return answer;
    }
    
    private static boolean checkSquare(int i, int j, Character[][] arr) {
        if(arr[i][j] == arr[i][j + 1] && arr[i][j + 1] == arr[i + 1][j] && arr[i + 1][j] == arr[i + 1][j + 1]) {
            return true;
        }
        
        return false;
    }
    
    private static int blockDown(Character[][] arr, boolean[][] checkArr) {
        int cnt = 0;
        
        for(int i = 0; i < checkArr.length; i++) {
            for(int j = 0; j < checkArr[0].length; j++) {
                if(checkArr[i][j]) {
                    arr[i][j] = 'X';
                    cnt++;
                }
            }
        }
        
        for(int i = 0; i < checkArr.length; i++) {
            Deque<Character> deque = new LinkedList<>();
            
            for(int j = 0; j < checkArr[0].length; j++) {
                if(arr[i][j] != 'X') {
                    deque.offerLast(arr[i][j]);
                }
            }

            int arrSize = deque.size();
            for(int k = 0; k < arr[0].length - arrSize; k++) {
                deque.offerFirst('X');
            }

            arr[i] = deque.toArray(new Character[0]);
        }
        
        return cnt;
    }
}