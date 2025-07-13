import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> ll = new ArrayList<>();
        while(true){
            ll.add(k);
            if(k<=1) break;
            if(k%2==0){
                k/=2;
            }else{
                k = k*3+1;   
            }
        }
        
        //배열에 정적분값 저장 0번 인덱스 -> 0~1 정적분한 값
        double[] integral = new double[ll.size()-1];
        for(int i=1; i<ll.size(); i++){
            integral[i-1] = Math.abs((ll.get(i-1)+ll.get(i))*0.5);
        }
        
        // System.out.println(ll);
        // System.out.println(Arrays.toString(integral));
        
        for(int i =0; i<ranges.length; i++){
            int[] r = ranges[i];
            double sum = 0;
            if(r[0] <= ll.size()-1+r[1]){
                for(int j = r[0]; j < ll.size()-1+r[1]; j++){
                    sum += integral[j];
                }
            } else {
                sum = -1;
            }
            answer[i] = sum;
        }
        
        return answer;
    }
    
    
}