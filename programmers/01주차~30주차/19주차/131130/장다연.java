//1. cards circuit and find the all case
import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int rtn = 0;
        //for(int i=0; i<cards.length; i++){
        rtn = Math.max(rtn, findScore(cards, 0));
        // }
        return rtn;
    }
    private int findScore(int[] cards, int s){
        List<List<Integer>> boxes = new ArrayList<>();
        boxes.add(new ArrayList<>());
        int boxIdx = 0;
        boolean[] visited = new boolean[cards.length];
        int changedCnt = 0;
        
        int nowIdx = s;
        int nowValue = cards[s];
        while(changedCnt < cards.length){
            if(!visited[nowIdx]){
                
            }
            else{
                for(int i=0; i<cards.length; i++){
                    if(!visited[i]){
                        nowIdx = i;
                        nowValue = cards[nowIdx];
                        boxes.add(new ArrayList<>());
                        boxIdx++;
                        break;
                    }
                }
            }
            List li = boxes.get(boxIdx);
            li.add(nowValue);
            visited[nowIdx] = true;
            changedCnt++;
            nowIdx = nowValue-1;
            nowValue = cards[nowIdx];
            
        }
        Collections.sort(boxes, new Comparator<>(){
            @Override
            public int compare(List o1, List o2){
                return o2.size()-o1.size();
            }
        });
        //System.out.println(boxes);
        if(boxes.size()==1) return 0;
        else return boxes.get(0).size()*boxes.get(1).size();
    }
}