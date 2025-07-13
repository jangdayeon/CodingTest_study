import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < places.length; i++) {
            char[][] place = new char[5][5];
            List<int[]> whereP = new ArrayList<>();
            
            for(int j = 0; j < 5; j++) {
                place[j] = places[i][j].toCharArray();
            }
            
            for(int k = 0; k < 5; k++) {
                for(int l = 0; l < 5; l++) {
                    if(place[k][l] == 'P') {
                        whereP.add(new int[]{k, l});
                    }
                }
            }
            
            boolean flag = true;
            
            loop:
            for(int k = 0; k < whereP.size(); k++) {
                for(int j = k + 1; j < whereP.size(); j++) {
                    int kx = whereP.get(k)[0]; int ky = whereP.get(k)[1];
                    int jx = whereP.get(j)[0]; int jy = whereP.get(j)[1];
                    
                    int distance = (Math.abs(jx - kx) + Math.abs(jy - ky));
                    
                    if(distance == 1) {
                        flag = false;
                        break loop;
                    } else if(distance == 2) {
                        if(kx == jx && place[kx][(ky + jy) / 2] == 'X') {
                            flag = true;
                        } else if(ky == jy && place[(kx + jx) / 2][ky] == 'X') {
                            flag = true;
                        } else if(kx != jx && ky != jy && place[kx][jy] == 'X' && place[jx][ky] == 'X') {
                            flag = true;
                        } else {
                            flag = false;
                            break loop;
                        }
                    }
                }
            }
            
            answer[i] = flag ? 1 : 0;
        }
        
        return answer;
    }
}