class Solution {
	public String solution(String p) {
		return recursive(new StringBuilder(p)).toString();
	}

	public StringBuilder recursive(StringBuilder sb) {
		if (sb.length() == 0)
			return new StringBuilder();

		// 2. u와 v로 분리
		int balance = 0;
		int index = 0;
		do {
			balance += sb.charAt(index) == '(' ? 1 : -1;
			index++;
		} while (balance != 0);

		StringBuilder u = new StringBuilder(sb.substring(0, index));
		StringBuilder v = new StringBuilder(sb.substring(index));

		// 3. u가 올바른 문자열인지 검사
		if (isCollect(u)) {
			return u.append(recursive(new StringBuilder(v.toString())));
		} else {
			StringBuilder answer = new StringBuilder();
			answer.append("(");
			answer.append(recursive(new StringBuilder(v.toString())));
			answer.append(")");
			u.deleteCharAt(0);
			u.deleteCharAt(u.length() - 1);
			u = reverseChar(u);
			answer.append(u);
			return answer;
		}
	}

	public StringBuilder reverseChar(StringBuilder sb) {
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < sb.length(); i++) {
			answer.append(sb.charAt(i) == '(' ? ')' : '(');
		}
		return answer;
	}

	public boolean isCollect(StringBuilder sb) {
		int balance = 0;
		for (int i = 0; i < sb.length(); i++) {
			balance += sb.charAt(i) == '(' ? 1 : -1;
			if (balance < 0)
				return false;
		}
		return true;
	}
}
