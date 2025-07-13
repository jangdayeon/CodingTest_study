//현재 기준으로 a가 나올 때까지 왼쪽 혹은 오른쪽으로 이동해서 전체적인 탐색 방법을 정하는 것임


class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] n = name.toCharArray();
        int y;
        int move = n.length-1;
        for(int x=0; x<n.length; x++){
            //System.out.println((n[i]-'A')+" "+('Z'-n[i]));
            answer += (n[x]-'A'<'Z'-n[x]+1) ? n[x]-'A' : 'Z'-n[x]+1;
            y = x+1;
            while(y < n.length && n[y] == 'A'){
                y += 1;
            }
            move = Math.min(move, Math.min(x+x+(n.length-y),(n.length-y)+(n.length-y)+x));
        }
        return answer+move;
    }
}