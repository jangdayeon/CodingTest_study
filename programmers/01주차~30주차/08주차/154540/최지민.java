import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    boolean[][] visited;
    
    class Node {
        int x;
        int y;
    
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < maps.length; i++) {
            for(char c : maps[i].toCharArray()) {
                graph.get(i).add(c == 'X' ? 0 : c - '0');
            }
        }
    
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                if(!visited[i][j] && graph.get(i).get(j) != 0) {
                    answer.add(bfs(i, j));
                }
            }
        }
        
        int[] result = answer.stream().mapToInt(Integer::intValue).toArray();
        
        Arrays.sort(result);
        
        return (answer.isEmpty()) ? new int[]{-1} : result;
    }
    
    private int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        
        int count = graph.get(x).get(y);
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                
                if(nx < 0 || nx >= graph.size() || ny < 0 || ny >= graph.get(0).size()) continue;
                if(graph.get(nx).get(ny) == 0) continue;
                
                if(!visited[nx][ny]) {
                    count += graph.get(nx).get(ny);
                    q.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        
        return count;
    }
    
}