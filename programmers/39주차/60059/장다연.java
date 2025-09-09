//답 확인함

import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        int size = n + (m - 1) * 2;

        for (int rot = 0; rot < 4; rot++) {
            key = rotateKey(key, m);
            for (int x = 0; x <= size - m; x++) {
                for (int y = 0; y <= size - m; y++) {
                    int[][] newKey = new int[size][size];
                    placeKey(newKey, key, m, x, y);
                    if (isCorrect(newKey, lock, m, n)) return true;
                }
            }
        }
        return false;
    }

    public boolean isCorrect(int[][] nk, int[][] lock, int m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lock[i][j] + nk[(m - 1) + i][(m - 1) + j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] rotateKey(int[][] key, int m) {
        int[][] rst = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rst[i][j] = key[m - 1 - j][i];
            }
        }
        return rst;
    }

    public void placeKey(int[][] nk, int[][] k, int m, int offsetX, int offsetY) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                nk[offsetX + i][offsetY + j] = k[i][j];
            }
        }
        for(int[] nknk : nk){
            System.out.println(Arrays.toString(nknk));
        }
        System.out.println();
    }
}
