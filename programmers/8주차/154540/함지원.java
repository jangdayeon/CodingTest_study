class Solution {
    public int[] solution(String[] maps) {
        int row = maps.length;
        int col = maps[0].length();
        boolean[][] check = new boolean[row][col]; // 섬에 방문 여부
        List<Integer> food = new LinkedList<>(); // 식량 정보

        int[] dx = {-1, 1, 0, 0}; // 좌, 우
        int[] dy = {0, 0, 1, -1}; // 상, 하

        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (!check[i][j] && maps[i].charAt(j) != 'X') {
                    int totalFood = 0;
                    queue.offer(new int[]{i, j});// 시작점
                    check[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        totalFood += maps[x].charAt(y) - '0';

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if (nx >= 0 && nx < row && ny >= 0 && ny < col && !check[nx][ny] && maps[nx].charAt(ny) != 'X') {
                                queue.offer(new int[]{nx, ny});
                                check[nx][ny] = true;
                            }
                        }
                    }

                    food.add(totalFood);
                }
            }
        }

        if (food.isEmpty()) return new int[]{-1};
        Collections.sort(food);
        int[] answer = new int[food.size()];

        for (int i = 0; i < food.size(); i++) answer[i] = food.get(i);

        return answer;
    }
}