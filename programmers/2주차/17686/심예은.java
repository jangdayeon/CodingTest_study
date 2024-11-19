import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        // 파일 배열을 정렬
        Arrays.sort(files, (file1, file2) -> {

            // 파일을 HEAD, NUMBER로 나눔
            String[] parts1 = splitFileName(file1);
            String[] parts2 = splitFileName(file2);

            // 1. HEAD를 대소문자 구분 없이 비교
            int headCompare = parts1[0].compareToIgnoreCase(parts2[0]);
            if (headCompare != 0) {
                return headCompare;
            }

            // 2. HEAD가 같으면 NUMBER를 숫자로 변환해서 비교
            int number1 = Integer.parseInt(parts1[1]);
            int number2 = Integer.parseInt(parts2[1]);
            return Integer.compare(number1, number2);
        });

        return files;
    }

    // 파일 이름을 HEAD와 NUMBER로 나누는 메서드
    private String[] splitFileName(String file) {
        String head = "";
        String number = "";

        int i = 0;

        // 1. HEAD 추출 (숫자가 나오기 전까지 문자 수집)
        while (i < file.length() && !Character.isDigit(file.charAt(i))) {
            head += file.charAt(i);
            i++;
        }

        // 2. NUMBER 추출 (숫자를 최대 5글자까지 수집)
        while (i < file.length() && Character.isDigit(file.charAt(i)) && number.length() < 5) {
            number += file.charAt(i);
            i++;
        }

        // HEAD와 NUMBER 반환
        return new String[] { head, number };
    }
}
