import java.util.*;

class Solution {
    // 시간을 "hh:mm"을 분 단위로 변환하는 메서드
    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    public String[] solution(String[][] plans) {
        // 과제 데이터를 리스트로 변환 후 시작 시간 기준 정렬
        List<Task> tasks = new ArrayList<>();
        for (String[] plan : plans) {
            String name = plan[0];
            int start = timeToMinutes(plan[1]); // timeToMinutes 호출
            int duration = Integer.parseInt(plan[2]);
            tasks.add(new Task(name, start, duration));
        }
        tasks.sort(Comparator.comparingInt(task -> task.start));

        Stack<Task> stack = new Stack<>(); // 멈춘 과제를 관리할 스택
        List<String> result = new ArrayList<>(); // 결과 저장
        int currentTime = 0;

        for (Task task : tasks) {
            // 진행 중인 과제들을 처리
            while (!stack.isEmpty() && currentTime < task.start) {
                Task previous = stack.pop();
                if (currentTime + previous.remaining <= task.start) {
                    // 이전 과제를 완전히 끝낼 수 있다면
                    currentTime += previous.remaining;
                    result.add(previous.name);
                } else {
                    // 이전 과제를 끝낼 수 없다면 다시 스택에 저장
                    previous.remaining -= (task.start - currentTime);
                    stack.push(previous);
                    currentTime = task.start;
                    break;
                }
            }

            // 새로운 과제를 시작
            currentTime = task.start;
            stack.push(new Task(task.name, task.start, task.remaining));
        }

        // 스택에 남은 과제를 처리
        while (!stack.isEmpty()) {
            Task task = stack.pop();
            result.add(task.name);
        }

        // 결과를 배열로 변환하여 반환
        return result.toArray(new String[0]);
    }
}

// Task 클래스를 정의
class Task {
    String name;
    int start;
    int remaining;

    Task(String name, int start, int remaining) {
        this.name = name;
        this.start = start;
        this.remaining = remaining;
    }
}
