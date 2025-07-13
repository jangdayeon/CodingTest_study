import java.util.Arrays;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int p = 0 ; p < 5 ; p++) {
            boolean valid = true;

            char[][] room = new char[5][5];
            for (int i = 0 ; i < 5 ; i++) {
                room[i] = places[p][i].toCharArray();
            }

            for (int i = 0 ; i < 5 && valid ; i++) {
                for (int j = 0 ; j < 5 && valid ; j++) {
                    if (room[i][j] == 'P') {
                        int[][] direct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                        for (int[] d : direct) {
                            int ni = i + d[0];
                            int nj = j + d[1];

                            if (ni >= 0 && ni < 5 && nj >= 0 && nj < 5) {
                                if (room[ni][nj] == 'P') {
                                    valid = false;
                                    break;
                                }
                            }
                        }

                        int[][] straight = {{-2, 0}, {2, 0}, {0, -2}, {0, 2}};
                        for (int[] s : straight) {
                            int ni = i + s[0];
                            int nj = j + s[1];

                            if (ni >= 0 && ni < 5 && nj >= 0 && nj < 5) {
                                if (room[ni][nj] == 'P') {
                                    if (s[0] == 0) {
                                        int mid = (j + nj) / 2;
                                        if (room[i][mid] != 'X') {
                                            valid = false;
                                            break;
                                        }
                                    } else {
                                        int mid = (i + ni) / 2;
                                        if (room[mid][j] != 'X') {
                                            valid = false;
                                            break;
                                        }
                                    }
                                }
                            }
                        }

                        int[][] diagonal = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
                        for (int[] d : diagonal) {
                            int ni = i + d[0];
                            int nj = j + d[1];
                            if (ni >= 0 && ni < 5 && nj >= 0 && nj < 5) {
                                if (room[ni][nj] == 'P') {
                                    if (room[i][nj] != 'X' || room[ni][j] != 'X') {
                                        valid = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            answer[p] = valid ? 1 : 0;
        }

        return answer;
    }
}