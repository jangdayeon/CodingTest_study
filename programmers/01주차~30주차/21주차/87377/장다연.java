//직선 2개씩 고른 조합을 모두 구하기(n==1000으로 O(n^2)까지 괜찮다)
//이 조합별로 교점을 set에 저장한다
//이 때 교점의 minX,maxX,minY,maxY를 갱신한다
//위의 값에 따라 answer 배열을 초기화하고
//set을 순회를 돌면서 별을 찍어준다.
import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        
        //combination 구하기
        List<int[]> combi = new ArrayList<>(); //line idx 조합 저장됨
        for(int i=0; i<line.length; i++){
            for(int j=i+1; j<line.length; j++){
                combi.add(new int[]{i,j});
            }
        }
        
        //교점 구하기
        Set<String> set = new HashSet<>();
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        
        for(int[] c: combi){
            int[] ABE = line[c[0]];
            int[] CDF = line[c[1]];
            long xSon = (long) ABE[1] * CDF[2] - (long) ABE[2] * CDF[1];
            long ySon = (long) ABE[2] * CDF[0] - (long) ABE[0] * CDF[2];
            long mother = (long) ABE[0]*CDF[1] - (long) ABE[1]*CDF[0];
            
            if (mother == 0L) continue;
            if (xSon % mother != 0L || ySon % mother != 0L) continue;
            long x = xSon / mother;
            long y = ySon / mother;
            
            set.add(x+" "+y);
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }
        
        //별 찍기
        char[][] ans = new char[(int)(maxY - minY) + 1][(int)(maxX - minX) + 1];
        for (char[] row : ans) {
            Arrays.fill(row, '.'); // 전부 '.'으로 초기화
        }
        for (String s_ : set) {
            long[] s = Arrays.stream(s_.split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
            ans[(int)(maxY - s[1])][(int)(s[0] - minX)] = '*';
        }
        String[] answer = new String[ans.length];
            for (int i = 0; i < ans.length; i++) {
            answer[i] = new String(ans[i]);
        }

        return answer;
    }
}