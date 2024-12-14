class Solution2 {
    // 1과 0인 영역의 개수를 저장
    int one = 0, zero = 0;

    // 재귀
    void press(int[][] arr, int xStart, int xEnd, int yStart, int yEnd){
        int oneCnt = 0, max = (int)Math.pow(xEnd - xStart, 2);
        // 순회하면서 1의 개수 세기
        for(int i = xStart; i < xEnd; i++){
            for(int j = yStart; j < yEnd; j++){
                oneCnt += arr[i][j];
            }
        }

        if(oneCnt == 0) zero++;
        else if(oneCnt == max) one++;
        else {
            int xMid = (xEnd + xStart) / 2;
            int yMid = (yEnd + yStart) / 2;
            press(arr, xStart, xMid, yStart, yMid);
            press(arr, xMid, xEnd, yStart, yMid);
            press(arr, xStart, xMid, yMid, yEnd);
            press(arr, xMid, xEnd, yMid, yEnd);
        }
    }

    public int[] solution(int[][] arr) {
        press(arr, 0, arr.length, 0, arr.length);
        return new int[]{zero, one};
    }
}