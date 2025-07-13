import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, (a, b) -> timeToMinutes(a[1]) - timeToMinutes(b[1]));

        Stack<Task> stack = new Stack<>();
        List<String> completed = new ArrayList<>();

        int currentTime = 0;

        for (String[] plan : plans) {
            String name = plan[0];
            int startTime = timeToMinutes(plan[1]);
            int duration = Integer.parseInt(plan[2]);

            // 현재 시간 이후 작업이 시작되기 전까지 처리
            while (!stack.isEmpty() && currentTime <= startTime) {
                Task ongoingTask = stack.pop();
                if (currentTime + ongoingTask.remainingTime <= startTime) {
                    // 현재 작업이 시작 시간 전에 끝남
                    currentTime += ongoingTask.remainingTime;
                    completed.add(ongoingTask.name);
                } else {
                    // 현재 작업을 시작 전에 다 못 끝냄
                    ongoingTask.remainingTime -= (startTime - currentTime);
                    stack.push(ongoingTask);
                    currentTime = startTime;
                    break;
                }
            }

            // 새 작업 추가
            stack.push(new Task(name, duration));
            currentTime = Math.max(currentTime, startTime); // 현재 시간 업데이트
        }

        // 남은 작업 처리
        while (!stack.isEmpty()) {
            completed.add(stack.pop().name);
        }

        // 결과 배열로 변환
        return completed.toArray(new String[0]);
    }

    // 시간을 "HH:mm"에서 분으로 변환
    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    // 작업 정보를 담는 클래스
    static class Task {
        String name;
        int remainingTime;

        Task(String name, int remainingTime) {
            this.name = name;
            this.remainingTime = remainingTime;
        }
    }
}