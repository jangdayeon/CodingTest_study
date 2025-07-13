public class Solution {
    public int[] solution(int brown, int yellow) {
        // 전체 격자 수
        int total = brown + yellow;

        // 가로(w)와 세로(h)의 관계를 직접 계산
        for (int w = 3; w <= total; w++) { // 가로는 전체 크기까지 가능
            if (total % w == 0) { // 전체 크기의 약수인지 확인
                int h = total / w; // 세로 계산

                // 가로 >= 세로 조건 만족 및 노란색 조건 검증
                if (w >= h && (w - 2) * (h - 2) == yellow) {
                    return new int[] {w, h}; // 가로, 세로 순서로 반환
                }
            }
        }
        return new int[0]; // 조건에 맞는 경우가 없으면 빈 배열 반환
    }
}
