class Solution {
    public int solution(String s) {
        int minLength = s.length();

        for (int len = 1; len <= s.length() / 2; len++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, len);
            int count = 1;

            for (int i = len; i <= s.length(); i += len) {
                String sub = (i + len <= s.length()) ? s.substring(i, i + len) : s.substring(i);

                if (sub.equals(prev)) count++;
                else {
                    compressed.append((count > 1 ? count : "")).append(prev);
                    prev = sub;
                    count = 1;
                }
            }

            compressed.append((count > 1 ? count : "")).append(prev);
            minLength = Math.min(minLength, compressed.length());
        }

        return minLength;
    }
}