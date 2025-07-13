import java.util.*;

class Solution {
    private static String[][] s;
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        s = new String[storage.length+2][storage[0].length()+2];
        for(int i=1; i<storage.length+1; i++){
            String[] temp = storage[i-1].split("");
            for(int j=1; j<=temp.length; j++){
                s[i][j] = temp[j-1];
            }
        }
        // for(int i=0; i<s.length;i++){
        //     System.out.println(Arrays.toString(s[i]));
        // }
        // System.out.println();
        
        for(String re : requests){
            if(re.length()==2){
                forkLift(re.substring(0,1));
            } else {
                crane(re);
            }
        }
        
        for(int i=0; i<s.length; i++){
            for(int j=0; j<s[0].length; j++){
                if(Objects.isNull(s[i][j])){
                    continue;
                }
                answer++;
            }
        }
        // for(int i=0; i<s.length;i++){
        //     System.out.println(Arrays.toString(s[i]));
        // }
        // System.out.println();
        
        return answer;
    }
    private static List searchSurround(String target, int i, int j){
        //상하좌우
        int[] x = {-1,1,0,0};
        int[] y = {0,0,-1,1};
        List<int[]> result = new ArrayList<>();
        for(int z=0; z<4; z++){
            if(i+x[z] <0 || i+x[z] >=s.length || j+y[z] <0 || j+y[z] >=s[0].length) continue;
            if(s[i+x[z]][j+y[z]] != null && s[i+x[z]][j+y[z]].equals(target)){
                result.add(new int[]{i+x[z],j+y[z]});
            } 
        }
        return result;
    }
    private static boolean isConnectedToTheOutside(int i, int j) {
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};
        boolean[][] visited = new boolean[s.length][s[0].length];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0], cy = current[1];

            for (int z = 0; z < 4; z++) {
                int nx = cx + x[z];
                int ny = cy + y[z];

                if (nx < 0 || nx >= s.length || ny < 0 || ny >= s[0].length) continue;

                if (s[nx][ny] == null && (nx == 0 || nx == s.length || ny == 0 || ny == s[0].length)) {
                    return true; // 외부와 연결됨
                }

                if (!visited[nx][ny] && s[nx][ny] == null) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
    //알파벳 한 번 반복
    private static void crane(String target){
        List<int[]> haveToBeNull = new ArrayList<>();
        for(int i=0; i<s.length; i++){
            for(int j=0; j<s[0].length; j++){
                if(isConnectedToTheOutside(i,j) && Objects.isNull(s[i][j])){
                    List<int[]> rst = searchSurround(target, i, j);
                    for(int[] r : rst){
                        haveToBeNull.add(r);
                    }
                }
            }
        }
        for(int[] r:haveToBeNull){
            s[r[0]][r[1]] = null;
        }
    }
    //알파벳 두 번 반복
    private static void forkLift(String target){
        for(int i=0; i<s.length; i++){
            for(int j=0; j<s[0].length; j++){
                if(s[i][j] != null && s[i][j].equals(target)){
                    s[i][j] = null;
                }
            }
        }
    }
}