class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0;

        // '#'이 붙은 음표를 단일 문자로 변환
        m = convertMelody(m);

        for (String info : musicinfos) {
            String[] parts = info.split(",");
            String startTime = parts[0];
            String endTime = parts[1];
            String title = parts[2];
            String sheet = convertMelody(parts[3]);

            // 재생 시간 계산
            int playTime = playTime(startTime, endTime);

            // 실제 재생된 멜로디 생성
            String playedMelody = melody(sheet, playTime);

            // 기억한 멜로디가 포함되어 있는지 확인
            if (playedMelody.contains(m)) {
                if (playTime > maxPlayTime) {
                    maxPlayTime = playTime;
                    answer = title;
                }
            }
        }

        return answer;
    }

    // '#'이 포함된 멜로디를 단일 문자로 변환
    private String convertMelody(String melody) {
        return melody.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("B#", "b")
                .replaceAll("A#", "a");
    }

    // 재생 시간 계산
    private int playTime(String start, String end) {
        String[] startParts = start.split(":");
        String[] endParts = end.split(":");

        int startHour = Integer.parseInt(startParts[0]);
        int startMinute = Integer.parseInt(startParts[1]);
        int endHour = Integer.parseInt(endParts[0]);
        int endMinute = Integer.parseInt(endParts[1]);

        return (endHour * 60 + endMinute) - (startHour * 60 + startMinute);
    }

    // 재생된 멜로디 생성
    private String melody(String sheet, int playTime) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < playTime; i++) {
            sb.append(sheet.charAt(i % sheet.length()));
        }

        return sb.toString();
    }
}