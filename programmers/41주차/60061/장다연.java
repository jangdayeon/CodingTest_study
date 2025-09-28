import java.util.*;

class Solution {
    private enum frameType{
        COLUMN, BEAM;
    }
    private enum actingType{
        INSTALL, REMOVE;
    }
    private boolean[][] columnBoard;
    private boolean[][] beamBoard;
    private int len;
    public int[][] solution(int n, int[][] build_frame) {
        List<int[]> answer = new ArrayList<>();
        len = n;
        columnBoard = new boolean[n+1][n+1];
        beamBoard = new boolean[n+1][n+1];
        for(int[] frame : build_frame){
            int x = frame[0], y = frame[1];
            frameType ft = frame[2] == 0 ? frameType.COLUMN : frameType.BEAM;
            actingType at = frame[3] == 0 ? actingType.REMOVE : actingType.INSTALL;
            switch(at){
                case INSTALL -> {if(canInstall(x,y,ft)) installFrame(x,y,ft);}
                case REMOVE -> {if(canRemove(x,y,ft)) removeFrame(x,y,ft);}   
            }
        }
        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                if(columnBoard[i][j]) answer.add(new int[]{i,j,0});
                if(beamBoard[i][j]) answer.add(new int[]{i,j,1});
            }
        }
        return listToSortedArr(answer);
    }
    private boolean canInstall(int x, int y, frameType ft){
        switch(ft){
                case COLUMN -> {
                    if(y==0) return true; //바닥에 있음
                    if((x-1 >=0 && beamBoard[x-1][y]) || beamBoard[x][y]) return true; //보의 한쪽 끝 위에 있음
                    if(y-1 >=0 && columnBoard[x][y-1]) return true; //딴 기둥 위
                }
                case BEAM -> {
                    if(y-1 >= 0 && columnBoard[x][y-1]) return true; //왼쪽 끝 부분에 기둥
                    if(x+1 <= len && y-1 >= 0 && columnBoard[x+1][y-1]) return true; //오른쪽 끝 부분에 기둥
                    if(x-1 >= 0 && x+1 <= len && (beamBoard[x-1][y] && beamBoard[x+1][y])) return true; //양쪽 끝 부분에 다른 보 있음
                }
        }
        return false;
    }
    private void installFrame(int x, int y, frameType ft){
        // System.out.println("install!" +(ft == frameType.COLUMN ? "column : ": "beam : ")+x + " "+ y );
        switch(ft){
                case COLUMN -> columnBoard[x][y] = true;
                case BEAM -> beamBoard[x][y] = true;
        }
    }
    private boolean canRemove(int x, int y, frameType ft){
        boolean rst = true;
        switch(ft){
                case COLUMN -> {
                    columnBoard[x][y] = false;
                    int[] dx = {x, x-1, x};
                    int[] dy = {y+1, y+1, y+1};
                    int[] da = {0, 1, 1}; //0은 기둥, 1은 보
                    for(int i=0; i<3; i++){
                        if(dx[i] < 0 || dx[i] > len || dy[i] < 0 || dy[i] > len) continue;
                        if(da[i] == 0 && columnBoard[dx[i]][dy[i]] && !canInstall(dx[i], dy[i], frameType.COLUMN)) rst = false;
                        if(da[i] == 1 && beamBoard[dx[i]][dy[i]] && !canInstall(dx[i], dy[i], frameType.BEAM)) rst = false;
                    }
                    columnBoard[x][y] = true;
                }
                case BEAM -> {
                    beamBoard[x][y] = false;
                    int[] dx = {x-1, x+1, x, x+1};
                    int[] dy = {y, y, y, y};
                    int[] da = {1, 1, 0, 0};
                    for(int i=0; i<4; i++){
                        if(dx[i] < 0 || dx[i] > len || dy[i] < 0 || dy[i] > len) continue;
                        if(da[i] == 0 && columnBoard[dx[i]][dy[i]] && !canInstall(dx[i], dy[i], frameType.COLUMN)) rst = false;
                        if(da[i] == 1 && beamBoard[dx[i]][dy[i]] && !canInstall(dx[i], dy[i], frameType.BEAM)) rst = false;
                    }
                    beamBoard[x][y] = true;
                }
        }
        return rst;
    }
    private void removeFrame(int x, int y, frameType ft){
        // System.out.println("remove!" +(ft == frameType.COLUMN ? "column : ": "beam : ")+x + " "+ y );
        
        switch(ft){
                case COLUMN -> columnBoard[x][y] = false;
                case BEAM -> beamBoard[x][y] = false;
        }
    }
    private int[][] listToSortedArr(List<int[]> answer) {
        // answer.sort(
        //     Comparator.<int[]>comparingInt(a -> a[0])
        //               .thenComparingInt(a -> a[1])
        //               .thenComparingInt(a -> a[2])
        // );

        return answer.toArray(new int[0][]);
    }

}