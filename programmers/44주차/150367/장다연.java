
class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i=0; i<numbers.length; i++){
            String binaryNum = getBinaryNum(numbers[i]);
            answer[i] = isPerfectBinaryTree(binaryNum);
        }
        return answer;
    }
    private String getBinaryNum(long num){
        //10진수를 2진수로 변환하고 포화이진트리가 되기 위해 오프셋을 추가해 리턴
        String binaryNum = Long.toBinaryString(num);
        int nodeCnt = 1;
        int level = 1;
        while(binaryNum.length() > nodeCnt){
            nodeCnt += Math.pow(2, level++);
        }
        int offset = nodeCnt - binaryNum.length();
        return "0".repeat(offset) + binaryNum;
    }
    private int isPerfectBinaryTree(String num){
        // 포화이진트리 검사를 재귀함수로 구현
        int len = num.length();
        if(len == 0) return 1;
        
        int root = len / 2;
        String left = num.substring(0, root);
        String right = num.substring(root + 1);
        
        if(num.charAt(root) == '0'){
            return isZeroTree(left) + isZeroTree(right) == 2 ? 1 : 0;
        }
        
        return isPerfectBinaryTree(left) + isPerfectBinaryTree(right) == 2 ? 1 : 0;
    }
    
    private int isZeroTree(String num){
        for(char n : num.toCharArray()){
            if(n == '1') return 0;
        }
        return 1;
    }
}