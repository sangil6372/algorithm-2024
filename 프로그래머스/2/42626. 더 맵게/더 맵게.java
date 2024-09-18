import java.util.*;


class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // 최소 힙 구현
        for (int sc : scoville) {
            heap.add(sc);
        }
        int cnt = 0;
        if (heap.peek()>= K){
            answer = 0;
            return answer;
        }
        
        while(!heap.isEmpty()&&heap.size()>1){
            cnt++;
            int min1 = heap.poll();
            int min2 = heap.poll();
            int newOne = min1+min2*2;
            heap.add(newOne);
            if (heap.peek()>=K){
                answer = cnt;           
                break;
            }
        }
        if (heap.peek() < K) answer = -1;
        
        return answer;
    }
}