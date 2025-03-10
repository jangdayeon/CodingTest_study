class Solution {
    int[][] answer;
    int idx = 0;
    public int[][] solution(int n) {
        answer = new int[(int) Math.pow(2,n)-1][2];
        hanoi(n,1,3,2);  //원반개수, 시작, 도착, 보조
        return answer;
    }
    
    private void hanoi(int n, int fromP, int toP, int auxP){
        if (n==1) {
            answer[idx][0] = fromP;
            answer[idx++][1] = toP;
            return;
        }
        hanoi(n-1, fromP, auxP, toP);
        answer[idx][0] = fromP;
        answer[idx++][1] = toP;
        hanoi(n-1, auxP, toP, fromP);
        
    }
}