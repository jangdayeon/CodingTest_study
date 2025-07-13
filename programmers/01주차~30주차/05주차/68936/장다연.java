//재귀 + 전탐으로 풀기
//2로 쪼개고 내부 값 모두 같으면 continue
            // 내부 값 다르면 2로 또 쪼개기
//카운팅은 전역함수로 저장
class Solution {
    int[] answer = {0,0};
    int[][] entire;
    public int[] solution(int[][] arr) {
        entire = arr;
        recursion(0,0,arr.length);
        return answer;
    }
    
    public void recursion(int x, int y, int r){ //전체 arr, 시작행, 시작열, 한 변 길이
        final int chk = entire[x][y];
        if(r == 1) {
            answer[chk] +=1;
            return;
        }
        for(int i=x;i<x+r;i++){
            for(int j=y;j<y+r;j++){
                if(chk != entire[i][j]) { //압축이 안될 땐?
                    recursion(x,y,r/2);
                    recursion(x+r/2,y,r/2);
                    recursion(x,y+r/2,r/2);
                    recursion(x+r/2,y+r/2,r/2);
                    return;
                }
            }
        }
        //같다면,
        answer[chk] += 1;
    }
}