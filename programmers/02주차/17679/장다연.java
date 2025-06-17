import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] table = new char[m][n];
        for(int i=0;i<m;i++){
            table[i]=board[m-i-1].toCharArray();
        }

        //제거할 수 있는 블록을 전부 제거할 때까지(flag로 체크)
        while(true){
        boolean flag=true;
        boolean[][] check =new boolean[m][n]; //제거할 블록 기록
        //블록체크
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n-1;j++){
                if(table[i][j]=='-'){
                    continue;
                }
                char a =table[i][j];
                if(table[i][j+1]==a&&table[i+1][j]==a&&table[i+1][j+1]==a){
                    check[i][j]=true;
                    check[i][j+1]=true;
                    check[i+1][j]=true;
                    check[i+1][j+1]=true;
                    flag=false;
                }
            }
        }
            
         //지울 블록이없으면 반복문 종료
        if(flag){
            break;
        }
        //체크된 블록 삭제("-"으로 변환)
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(check[i][j]){
                    table[i][j]='-';
                    answer++;
                }
            }
        }
        //***블록 내리기 (윗블록과 스왑하기)***
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(table[i][j]=='-'){
                   for(int k=i;k<m;k++){ //해당 블록부터 아래로 보낼 위치를 찾아 보내고 다음 블록값 변경
                       if(table[k][j]=='-'){
                           continue;
                       }
                       table[i][j]=table[k][j];
                       table[k][j]='-';
                       break;
                   }
                }
            }
        }
    }   
        return answer;
    }
}
