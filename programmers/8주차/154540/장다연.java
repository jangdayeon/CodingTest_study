import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int[][] map = mapsSetting(maps);
        boolean[][] visited = new boolean[map.length][map[0].length];
        List<Integer> result = new ArrayList<>();
        int[] dirt = {-1, 1, 0, 0}; // 상하좌우
        int[] dirtB = {0, 0, -1, 1};
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!visited[i][j] && map[i][j] != -1) {
                    int food = 0;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[] {i, j});
                    while (!q.isEmpty()) {
                        int[] current = q.poll();
                        int nowA = current[0];
                        int nowB = current[1];
                        
                        if (visited[nowA][nowB]) continue;
                        
                        visited[nowA][nowB] = true;
                        food += map[nowA][nowB];
                        
                        for (int k = 0; k < 4; k++) {
                            int newA = nowA + dirt[k];
                            int newB = nowB + dirtB[k];
                            if (newA >= 0 && newA < map.length && newB >= 0 && newB < map[0].length && !visited[newA][newB] && map[newA][newB] != -1) {
                                q.offer(new int[] {newA, newB});
                            }
                        }
                    }
                    result.add(food);
                }
            }
        }
        
        if (result.isEmpty()) {
            return new int[] {-1};
        } else {
            Collections.sort(result);
            return result.stream().mapToInt(i -> i).toArray();
        }
    }
     public int[][] mapsSetting(String[] maps) {
        int[][] map = new int[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'X') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }
        return map;
    }
}