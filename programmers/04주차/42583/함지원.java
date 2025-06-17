import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();

        int time = 0;
        int bridgeWeight = 0;

        for (int i = 0; i < bridge_length; i++) bridge.add(0);

        for (int truck : truck_weights) {
            while (true) {
                bridgeWeight -= bridge.poll();

                if (bridgeWeight + truck <= weight) {
                    bridge.add(truck);
                    bridgeWeight += truck;
                    time++;
                    break;
                } else {
                    bridge.add(0);
                    time++;
                }
            }
        }
        time += bridge_length;

        return time;
    }
}