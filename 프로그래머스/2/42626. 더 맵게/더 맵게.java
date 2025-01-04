import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville){
            pq.add(s);
        }
        int cnt = 0;
        
        while(pq.size()>1){
            if(pq.peek() >= K) break;
            cnt++;
            int min1 = pq.poll();
            int min2 = pq.poll();
            int newOne = min1 + min2*2;
            
            pq.add(newOne);
        }
        if (pq.peek() < K) {
            return -1;
        }
        
        return cnt;
    }
}