import java.util.*;

class Solution {
    private class Person {
        Set<Person> front; // 나를 이긴 사람들
        Set<Person> back;  // 내가 이긴 사람들

        public Person() {
            front = new HashSet<>();
            back = new HashSet<>();
        }
    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            persons.add(new Person());
        }

        // 직접 경기 결과 저장
        for (int[] result : results) {
            Person winner = persons.get(result[0] - 1);
            Person loser = persons.get(result[1] - 1);

            winner.back.add(loser);   // winner는 loser를 이김
            loser.front.add(winner);  // loser는 winner에게 짐
        }

        // 각 선수별로 BFS 돌려서 간접 승패 관계 누적
        for (int i = 0; i < n; i++) {
            Person cur = persons.get(i);

            // 1) 내가 이긴 선수(back) 확장
            Queue<Person> q = new LinkedList<>(cur.back);
            while (!q.isEmpty()) {
                Person next = q.poll();
                for (Person nn : next.back) {
                    if (!cur.back.contains(nn)) {
                        cur.back.add(nn);
                        q.add(nn);
                    }
                }
            }

            // 2) 내가 진 선수(front) 확장
            q = new LinkedList<>(cur.front);
            while (!q.isEmpty()) {
                Person next = q.poll();
                for (Person nn : next.front) {
                    if (!cur.front.contains(nn)) {
                        cur.front.add(nn);
                        q.add(nn);
                    }
                }
            }
        }

        // 순위가 확정된 선수 카운트
        for (Person p : persons) {
            if (p.front.size() + p.back.size() == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}
