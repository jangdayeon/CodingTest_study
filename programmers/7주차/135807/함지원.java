class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int resultA = arrayA[0];
        int resultB = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) resultA = GCD(resultA, arrayA[i]);
        for (int i = 1; i < arrayB.length; i++) resultB = GCD(resultB, arrayB[i]);

        return Math.max(isValid(arrayB, resultA), isValid(arrayA, resultB));
    }

    public static int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static int isValid(int[] arr, int result) {
        for (int card : arr) {
            if (result == 1) {
                result = 0;
                break;
            } else if (card % result == 0) {
                result = 0;
                break;
            }
        }
        return result;
    }
}