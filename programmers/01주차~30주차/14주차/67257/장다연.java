//연산자 우선순위 조합 먼저 구하기
//완탐 문제

import java.util.regex.*;
import java.util.*;

class Solution {
	public static List<List<String>> order = new ArrayList<>();

	public long solution(String expression) {
		long answer = 0;

		//연산자 찾기
		Pattern pattern = Pattern.compile("[^0-9]+");
		Matcher matcher = pattern.matcher(expression);
		Set<String> operator = new TreeSet<>();
		while (matcher.find()) {
			operator.add(matcher.group());
		}
		// System.out.println(operator.toString());

		//연산자 조합 찾기
		permutation(operator.toArray(), new String[operator.size()], new boolean[operator.size()], 0, operator.size());

		// System.out.println(order.toString());

		//완전 탐색
		for (List o : order) {
			// System.out.println(o);
			answer = Math.max(answer, Math.abs(calculator(o, expression)));
		}

		return answer;
	}

	public long calculator(List o, String str) {
		Deque<String> s = new ArrayDeque<>();
		Deque<String> s2 = new ArrayDeque<>();
		Pattern pattern = Pattern.compile("([0-9]+|[^0-9])");
		Matcher matcher = pattern.matcher(str);

		while (matcher.find()) {
			s.addLast(matcher.group());
		}

		for (Object operator : o) {
			String oper = (String)operator;

			while (!s.isEmpty()) {
				String now = s.pollFirst();

				if (!now.equals(oper)) {
					s2.addLast(now);
				} else {
					String left = s2.pollLast();
					String right = s.pollFirst();

					s2.addLast(tokenCalculator(left, right, oper));
				}
			}

			// s2 -> s로 이동 (새로운 계산을 위해)
			while (!s2.isEmpty()) {
				s.addLast(s2.pollFirst());
			}

		}

		return Long.parseLong(s.pollFirst());
	}

	public String tokenCalculator(String left, String right, String operator) {
		switch (operator) {
			case "+":
				return String.valueOf(Long.valueOf(left) + Long.valueOf(right));
			case "-":
				return String.valueOf(Long.valueOf(left) - Long.valueOf(right));
			case "*":
				return String.valueOf(Long.valueOf(left) * Long.valueOf(right));
		}
		return "";
	}

	public void permutation(Object[] arr, String[] out, boolean[] visited, int depth, int r) {
		if (depth == r) {
			order.add(new ArrayList<>(Arrays.asList(out)));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				out[depth] = (String)arr[i];
				permutation(arr, out, visited, depth + 1, r);
				visited[i] = false;
			}
		}
	}
}
