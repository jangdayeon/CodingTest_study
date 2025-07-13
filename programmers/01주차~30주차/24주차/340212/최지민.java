class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int level = 0;
        
        long time = 0;
        int left = 1; // time이 커짐
        int right = 100000; // time이 작아짐
        
        while(right >= left) {
            time = 0;
            level = (left + right) / 2;
            
            for(int i = 0; i < diffs.length; i++) {
                if(level >= diffs[i]) {
                    time += times[i];
                } else if(level < diffs[i]) {
                    time += (diffs[i] - level) * (times[i] + ((i != 0) ? times[i - 1] : 0)) + times[i];
                }
            }
            
            if(time > limit) left = level + 1;
            else right = level - 1;
        };
        
        return left;
    }
}