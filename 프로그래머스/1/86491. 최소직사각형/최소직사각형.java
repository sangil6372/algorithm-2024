import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        PriorityQueue<Integer> width = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> height = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int[] size : sizes){
            width.add(Math.min(size[0],size[1]));
            height.add(Math.max(size[0],size[1]));
        }
        answer = width.poll()*height.poll();
        
        return answer;
    }
}