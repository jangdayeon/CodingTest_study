import java.util.*;

class Robot {
    int x, y;       // 현재 위치
    int idx;        // routes 내의 robot 인덱스
    int time;       // 현재 시간 (몇 턴인지)
    int nowGoal;     // routes 내 robot이 가고 있는 포인트(idx)
    
    public Robot(int x, int y, int idx, int time, int nowGoal){
        this.x = x;
        this.y = y;
        this.idx = idx;
        this.time = time;
        this.nowGoal = nowGoal;
    }
}

class Solution {
    public int solution(int[][] points, int[][] routes) {
        //index 0부터 시작하도록 수정
        for(int i=0; i<points.length; i++){
            for(int j=0; j<points[0].length; j++){
                points[i][j]--;
            }
        }
        for(int i=0; i<routes.length; i++){
            for(int j=0; j<routes[0].length; j++){
                routes[i][j]--;
            }
        }
        
        int answer = 0;
        Deque<Robot> q = new ArrayDeque<>();
        Map<String, Integer> record = new HashMap<>();
        //key == "현재시간 x y" / value == 그 시간에 그 곳을 지난 로봇의 수
        for (int i = 0; i < routes.length; i++) {
            int x = points[routes[i][0]][0];
            int y = points[routes[i][0]][1];
            q.add(new Robot(x, y, i, 0, 1));

            // time == 0일 때 시작 위치 기록
            String key = "0 " + x + " " + y;
            record.put(key, record.getOrDefault(key, 0) + 1);
        }
        
        while (!q.isEmpty()) {
            Robot robot = q.remove();
            int endX = points[routes[robot.idx][robot.nowGoal]][0];
            int endY = points[routes[robot.idx][robot.nowGoal]][1];
            if(robot.x==endX && robot.y==endY){
                if(robot.nowGoal == routes[robot.idx].length-1) continue;
                else {
                    robot.nowGoal += 1;
                    q.add(new Robot(robot.x, robot.y, robot.idx, robot.time, robot.nowGoal));
                    continue;
                }
            }
            if(robot.x != endX){
                int newX = robot.x > endX ? robot.x - 1 : robot.x + 1;
                q.add(new Robot(newX, robot.y, robot.idx, robot.time + 1, robot.nowGoal));
                String key = (robot.time + 1) + " " + newX + " " + robot.y;
                record.put(key, record.getOrDefault(key, 0) + 1);
                continue;
            }
            if(robot.y != endY){
                int newY = robot.y > endY ? robot.y - 1 : robot.y + 1;
                q.add(new Robot(robot.x, newY, robot.idx, robot.time + 1, robot.nowGoal));
                String key = (robot.time + 1) + " " + robot.x + " " + newY;
                record.put(key, record.getOrDefault(key, 0) + 1);
                continue;
            }

            
        }
        for(String r : 	record.keySet()){
            if(record.get(r)>=2) answer++;
        }
        return answer;
    }
}