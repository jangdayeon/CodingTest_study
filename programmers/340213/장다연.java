class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        //"mm:ss" 형식이란 점을 통해 모든 시간을 substring 함수를 이용해서 파싱
        int video_l = Integer.parseInt(video_len.substring(0,2))*60+Integer.parseInt(video_len.substring(3,5));
        int op_s = Integer.parseInt(op_start.substring(0,2))*60+Integer.parseInt(op_start.substring(3,5));
        int op_e = Integer.parseInt(op_end.substring(0,2))*60+Integer.parseInt(op_end.substring(3,5));
        int now = Integer.parseInt(pos.substring(0,2))*60+Integer.parseInt(pos.substring(3,5));
        
        
        //commands 하나하나 처리 시작
        for(String c:commands){
            //현재 위치가 오프닝 구간이면 now값 변경
            if(now >= op_s && now <= op_e){
            now = op_e;
            }
            //변경 후 commands에 대한 처리 진행
            if (c.equals("next")){
                now += 10;
                if(now > video_l){ //비디오를 넘을 경우
                    now = video_l;
                } else if(now >= op_s && now <= op_e){ //오프닝 구간일 경우
                    now = op_e;
                }
            }
            else{
                now -= 10;
                if(now < 0){ //비디오를 넘을 경우
                    now = 0;
                } else if(now >= op_s && now <= op_e){ //오프닝 구간일 경우
                    now = op_e;
                }
            }
        }
        
        String answer = ""; //문자열 += 연산을 통해 "mm:ss" 형식으로 만듦
        if(now/60 < 10) answer += "0"; //분은 몫 연산으로 풀었고, 한자리 수일 경우는 따로 0을 붙여줌
        answer += (now/60) + ":";
        if(now%60 < 10) answer += "0"; //초는 나머지 연산. 한자리 수일 경우는 앞에 0을 붙여줌
        answer += (now%60);
        return answer;
    }
}