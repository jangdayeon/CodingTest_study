class Solution {
    public int solution(int seat, String[][] passengers) {
        int num_passenger = 0;

        // 정류장별로 탑승/하차 승객 수를 계산
        for (int i = 0; i < passengers.length; i++) {
            num_passenger += func4(passengers[i]); // 탑승한 승객 수를 더함
            num_passenger -= func3(passengers[i]); // 하차한 승객 수를 뺌
        }

        // 남은 좌석 수를 계산하고 음수면 0으로 설정
        int answer = func1(seat - num_passenger);
        return answer;
    }

    // func1: 남은 좌석 수가 음수이면 0으로, 양수이면 그대로 반환
    public int func1(int num) {
        if (0 > num) {
            return 0;
        } else {
            return num;
        }
    }

    // func2: 음수를 그대로 반환하고 양수면 0으로 처리 (사용되지 않음)
    public int func2(int num) {
        if (num > 0) {
            return 0;
        } else {
            return num;
        }
    }

    // func3: "Off" 상태의 개수를 세어, 하차한 승객 수 반환
    public int func3(String[] station) {
        int num = 0;
        for (int i = 0; i < station.length; i++) {
            if (station[i].equals("Off")) {
                num += 1; // "Off"의 개수를 카운트
            }
        }
        return num;
    }

    // func4: "On" 상태의 개수를 세어, 탑승한 승객 수 반환
    public int func4(String[] station) {
        int num = 0;
        for (int i = 0; i < station.length; i++) {
            if (station[i].equals("On")) {
                num += 1; // "On"의 개수를 카운트
            }
        }
        return num;
    }
}
