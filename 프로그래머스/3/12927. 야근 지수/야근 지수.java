import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        /*
        야근 시작 시점에서의 남은 일 작업량 제곱
        N시간 동안 야근 피로도 최소화 
        1시간에 작업량 1 
        */
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());
        
        int sum = 0;
        for (int work : works){
            sum+=work;
            pQ.add(work);
        }
        if (n > sum ) return 0;
        
        
        for (int i = 0 ; i < n ;i++){
            int now = pQ.poll()-1;
            pQ.add(now);
        }
        
        for (int p : pQ){
            answer+= Math.pow(p,2);
        }
        
        
        
        
        return answer;
    }
}