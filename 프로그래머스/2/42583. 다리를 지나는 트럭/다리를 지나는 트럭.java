import java.util.*;


class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Deque<int[]> bridge = new ArrayDeque<>();

        // for (int i = 0 ;i < truck_weights.length; i++){
        int index = 0;
        int time = 0;
        int curWeight = 0;
        
        while(index < truck_weights.length ||!bridge.isEmpty()){
            time ++;
            
            // 다리 위에 있는 트럭 이동
            if (!bridge.isEmpty() && bridge.peek()[1] == bridge_length){
                curWeight -= bridge.pollFirst()[0];
            }
            
            // 다음 트럭을 다리위에 올릴 수 있는지 확인 
            if (index < truck_weights.length && curWeight + truck_weights[index] <= weight){
                bridge.addLast(new int[] {truck_weights[index], 0});
                curWeight += truck_weights[index];
                index++;
            }
            
            // 모든 트럭 한 칸씩 이동
            for (int[] truck : bridge){
                truck[1] ++;
            }
            
            
        }
        
        
            
        
        
        return time;
    }
}