# [다연] 49993 - [PCCP 기출문제] 1번 / 동영상 재생기

문자열 관련 외워야 할 함수

1. 문자열 나누기
    - 문자열.split() 함수 사용
    - 문자열.substring(,) 함수 사용

2. 문자열 포맷팅
    - String.format("$02d", 문자열);

# [예은] 340199 - [PCCE 기출문제] 9번 / 지폐 접기

1. 문자열 포맷 설정
    - String.format("%02d", "");

2. 정사각형 한 변의 최대 길이를 구하는 방법
    - array[i][j]+=Math.min(array[i-1][j-1], Math.min(array[i-1][j], array[i][j-1]));

3. 문자열 범위 지정
    - 문자열.substring(인덱스 범위);

# [지민] 340198 - [PCCE 기출문제] 10번 / 공원

- 2차원 배열에서 최대 정사각형의 길이를 구하는 로직

```
for(int i = 1; i < array.length; i++) {
    for(int j = 1; j < array[0].length; j++) {
        if(array[i][j] == 1) {
	    array[i][j] += Math.min(array[i - 1][j - 1], Math.min(array[i - 1][j], array[i][j - 1]));
	}
    }
}
```

- 자바 스트림

  - 스트림의 기본적인 틀 ( https://futurecreator.github.io/2018/08/26/java-8-streams/ )
  - sum, max, min, count, average
    각 연산들은 기본적으로 Optional 변수로 반환
    ex) Arrays.stream(arr).max().getAsInt();

- for문을 통해 배열에서 최대나 최소값을 찾아야 할 때 미리 배열을 정렬 후에 for문을 통해 탐색하면 더 빠른 시간내에 탐색 가능

- label, continue
  label : 반복문 앞에 위치해 break 또는 continue 동작 지점을 지정
  ( https://velog.io/@jyysyl6/%EC%9E%90%EB%B0%94-break%EB%AC%B8%EA%B3%BC-continue%EB%AC%B8 )

- 완탐 풀이 방법 중 가장 이해가 쉬운 풀이

```
import java.util.*;

class Solution {
    static String[][] park;

    // 돗자리가 (x, y)에서 시작하는 정사각형으로 깔릴 수 있는지 체크하는 함수
    static boolean check(int x, int y, int size) {
        int n = park.length;
        int m = park[0].length;

        // 돗자리가 공원의 경계를 넘는지 확인
        if (x + size > n || y + size > m) return false;

         // size x size 영역에 다른 사람이 있는지 확인
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!"-1".equals(park[x + i][y + j])) {
                    return false; // 사람이 있으면 false 반환
                }
            }
        }
        return true; // 깔 수 있으면 true 반환
    }

    public int solution(int[] mats, String[][] inputPark) {
        park = inputPark; // 전역 변수에 공원 정보를 할당
        Arrays.sort(mats); // 돗자리를 작은 것부터 큰 것 순으로 정렬
        int maxMat = -1; // 깔 수 있는 가장 큰 돗자리 크기를 저장

                // 공원의 모든 좌표에 대해 돗자리를 깔 수 있는지 확인
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length; j++) {
                if ("-1".equals(park[i][j])) { // 현재 위치가 빈 공간일 때만
                    // 각 돗자리 크기에 대해 확인
                    for (int matSize : mats) {
                        if (check(i, j, matSize)) {
                            maxMat = Math.max(maxMat, matSize); // 가장 큰 돗자리 크기를 저장
                        }
                    }
                }
            }
        }

        return maxMat;
    }
}
```

# [지원] 49993 - 스킬 트리 ( +340198 )

-  int의 두 값의 최대, 최소 구하기
    - Arrays.stream(wallet).max().getAsInt();
    - Arrays.stream(wallet).min().getAsInt();

#### 공원 - 340198

- static 메서드 만들어서 문제도 풀어보기
  static boolean check(int x, int y, int size) {
  int n = park.length;
  int m = park[0].length;

          // 돗자리가 공원의 경계를 넘는지 확인
          if (x + size > n || y + size > m) return false;

          // size x size 영역에 다른 사람이 있는지 확인
          for (int i = 0; i < size; i++) {
              for (int j = 0; j < size; j++) {
                  if (!"-1".equals(park[x + i][y + j])) {
                      return false; // 사람이 있으면 false 반환
                  }
              }
          }
          return true; // 깔 수 있으면 true 반환
      }
