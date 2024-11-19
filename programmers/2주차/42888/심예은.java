class Solution {
    public String[] solution(String[] record) {
        // 유저 아이디와 닉네임을 매핑할 배열
        String[] uidNickname = new String[100000];  // 유저 아이디는 최대 10^5개까지 가능
        int resultCount = 0;  // 결과 배열에 저장할 메시지 개수

        // 1. 유저 닉네임
        for (String status : record) {
            String[] splitStatus = status.split(" ");
            String action = splitStatus[0]; // "Enter", "Leave", "Change"
            String uid = splitStatus[1]; // 유저 아이디

            // uid를 해시값으로 변환한 인덱스를 미리 계산
            int uidIndex = Math.abs(uid.hashCode()) % 100000;  // 해시값이 음수일 수 있으므로 양수로 변환

            if (action.equals("Enter") || action.equals("Change")) {
                String nickname = splitStatus[2]; // 닉네임
                uidNickname[uidIndex] = nickname;  // 해당 유저의 최신 닉네임 저장
            }
        }

        // 2. 결과 메시지 생성
        String[] result = new String[record.length];  // 결과 배열 크기 설정
        for (String status : record) {
            String[] splitStatus = status.split(" ");
            String action = splitStatus[0]; // "Enter", "Leave", "Change"
            String uid = splitStatus[1]; // 유저 아이디

            // uid를 해시값으로 변환한 인덱스를 미리 계산
            int uidIndex = Math.abs(uid.hashCode()) % 100000;  // 해시값이 음수일 수 있으므로 양수로 변환
            String nickname = uidNickname[uidIndex];  // 해당 유저의 최신 닉네임 확인

            if (action.equals("Enter")) {
                result[resultCount++] = nickname + "님이 들어왔습니다.";
            } else if (action.equals("Leave")) {
                result[resultCount++] = nickname + "님이 나갔습니다.";
            }
            // "Change"는 결과에 포함 x
        }

        // result 배열에서 필요한 부분만 반환
        String[] finalResult = new String[resultCount];
        System.arraycopy(result, 0, finalResult, 0, resultCount);
        return finalResult;
    }
}