import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 1. 필터링 단계: 조건에 맞는 데이터만 저장할 임시 배열
        int[][] temp = new int[data.length][4];
        int count = 0;

        for (int i = 0; i < data.length; i++) {
            if ((ext.equals("code") && data[i][0] < val_ext) ||
                    (ext.equals("date") && data[i][1] < val_ext) ||
                    (ext.equals("maximum") && data[i][2] < val_ext) ||
                    (ext.equals("remain") && data[i][3] < val_ext)) {
                temp[count++] = data[i]; // 조건을 만족하면 temp 배열에 추가
            }
        }

        // 2. 결과 배열 크기에 맞게 복사
        int[][] filteredData = Arrays.copyOf(temp, count);

        // 3. 정렬 단계: Comparator로 sort_by 기준 정렬
        int sortIndex = getSortIndex(sort_by);
        Arrays.sort(filteredData, (a, b) -> Integer.compare(a[sortIndex], b[sortIndex]));

        return filteredData;
    }

    // 정렬 기준에 따른 열 인덱스를 반환
    private int getSortIndex(String sort_by) {
        switch (sort_by) {
            case "code": return 0;
            case "date": return 1;
            case "maximum": return 2;
            case "remain": return 3;
            default: throw new IllegalArgumentException("Invalid sort_by value");
        }
    }
}