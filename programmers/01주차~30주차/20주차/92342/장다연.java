//전체 탐색, 백트래킹
//라이언의 점수가 가장 높기만해서 좋은 것이 아니라, 어피치의 점수는 최소화하고 라이언 점수는 최대화하는 경우를 구해야하는 것임!
import java.util.*;

class Solution {
    public int[] output = new int[11];
    public int scoreDiff = 0;
    public int[] result;
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        
        permutation(info, n, 0, 0, 0, 11);
        System.out.println(Arrays.toString(result));

        if (result != null) return result;
    
        return new int[] {-1};
    }
    public void permutation(int[] info, int restArrow, int nowLionScore, int nowAppeachScore, int r, int dept){ 
        if (r == dept) {
            output[10] += restArrow;
            int diff = nowLionScore - nowAppeachScore;
            if (diff > 0) {
                if (scoreDiff < diff) {
                    scoreDiff = diff;
                    result = output.clone();
                } else if (scoreDiff == diff) {
                    for (int i = 10; i >= 0; i--) {
                        if (output[i] > result[i]) {
                            result = output.clone();
                            break;
                        } else if (output[i] < result[i]) {
                            break;
                        }
                    }
                }
            }

            if (restArrow > 0) output[10] -= restArrow;
            return;
        }
        
        for(int i=0; i<=restArrow; i++){
            output[r] = i;
            int lionScore = nowLionScore;
            int appeachScore = nowAppeachScore;

            if (info[r] == 0 && i == 0) {
                // 아무도 점수 못 가져감
            } else if (info[r] < i) {
                lionScore += (10 - r);
            } else if (info[r] > 0) {
                appeachScore += (10 - r);
            }

            permutation(info, restArrow - i, lionScore, appeachScore, r + 1, dept);
            output[r] = 0;
        }
    }
}