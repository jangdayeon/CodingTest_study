class Solution {
    public int solution(String[] babbling) {
        int count = 0;

        String[] words = {"aya", "ye", "woo", "ma"};

        for (String word : babbling) {
            String prev = "";
            boolean isValid = true;

            while (word.length() > 0) {
                boolean isMatched = false;

                // validWords 중 하나와 일치하는지 확인
                for (String valid : words) {
                    if (word.startsWith(valid) && !valid.equals(prev)) {
                        // 일치하는 발음이 있고, 이전 발음과 같지 않으면
                        word = word.substring(valid.length()); // 그 발음 제거
                        prev = valid; // 이전 발음 갱신
                        isMatched = true;
                        break;
                    }
                }

                // 일치하는 발음이 없으면 fasle
                if (!isMatched) {
                    isValid = false;
                    break;
                }
            }

            // 유효한 단어라면 카운트
            if (isValid) {
                count++;
            }
        }
        return count;
    }
}