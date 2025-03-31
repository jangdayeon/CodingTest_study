import java.util.*;

class Node{
    int x;
    int y;
    
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    //key == 몇 열, value == 그 열에 저장된 석유 크기
    Map<Integer, List<Integer>> cols = new HashMap<>();
    
    public int solution(int[][] land) {
        int answer = 0;
        for(int i=0; i<land[0].length; i++){
            cols.put(i, new LinkedList<>());
        }
        bfs(land);
        for(List<Integer> l : cols.values()){
            answer = Math.max(answer, l.stream().reduce(0, Integer::sum));
        }
        return answer;
    }

    public void bfs(int[][] land){
        int[][] visited = new int[land.length][land[0].length];
        
        Queue<Node> q = new LinkedList<>();

        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(land[i][j] == 1 && visited[i][j] == 0) { // 1인 곳만 탐색
                    q.add(new Node(i, j));
                    visited[i][j] = 1;

                    int dept = 0;  // 방문한 개수 카운트
                    Set<Integer> colSet = new HashSet<>();
                    colSet.add(j);

                    while (!q.isEmpty()) {
                        Node now = q.poll();
                        dept++;  // 큐에서 꺼낼 때마다 카운트 증가

                        // 상하좌우 확인
                        int[] dx = {-1,1,0,0};
                        int[] dy = {0,0,-1,1};

                        for(int z=0; z<4; z++){
                            int nx = now.x + dx[z];
                            int ny = now.y + dy[z];

                            if(isInBinary(land, nx, ny) && visited[nx][ny] == 0 && land[nx][ny] == 1) {
                                q.add(new Node(nx, ny));
                                visited[nx][ny] = 1;
                                colSet.add(ny);
                            }
                        }
                    }
                    
                    for(int y : colSet){
                        cols.get(y).add(dept);
                    }
                }
            }
        }
    }

    private boolean isInBinary(int[][] land, int x, int y){
        return x >= 0 && x < land.length && y >= 0 && y < land[0].length;
    }
}
