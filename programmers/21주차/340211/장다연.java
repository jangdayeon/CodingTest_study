//routes는 로봇의 이동 경로(from point to point)
//다음 포인트로 이동할 때는 항상 최단 경로로 이동하며 최단 경로가 여러 가지일 경우, r 좌표가 변하는 이동을 c 좌표가 변하는 이동보다 먼저 합니다.
//최단경로 알고리즘까지 사용할 필요 없이, r로 최대한 이동 후 c로 최대한 이동하면 됨

//queue에 로봇을 모두 넣고, queue.size() == 0 일 경우 while문을 종료한다.
//queue 내에 temp_queue를 만들어서 queue에 있는 값을 모두 넣고,
//temp_queue가 만들어진 시간에 temp_queue에 있는 값을 빼내어 r을 더 뺄 수 있으면 r을 빼고, 그게 아니면 c를 뺀다.
//만약 빼내었을 때 routes[1]과 같다면 그 로봇을 temp_queue에 다시 추가하지 않는다.
//각 시간 별로 로봇의 위치를 모두 저장하여 겹치는 값 만큼 result에 더한다.
//queue를 temp_queue로 치환한다.
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
        Queue<Robot> q = new LinkedList<>();
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
        // System.out.println(record);
        for(String r : 	record.keySet()){
            if(record.get(r)>=2) answer++;
        }
        return answer;
    }
}