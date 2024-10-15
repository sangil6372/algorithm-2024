import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> queue = new LinkedList<>();
        
        // 남은 일수를 큐에 넣는다 
        Queue<Integer> answer = new LinkedList<>();
        
        
        for (int i = 0 ;i < progresses.length;i++){
            int remainDays =  (100 - progresses[i]+speeds[i]-1)/speeds[i];
            queue.add(remainDays);
        }
        
        while(!queue.isEmpty()){
            int q = queue.poll();
            int cnt = 1;
            
            while(!queue.isEmpty() && queue.peek() <= q){
                queue.poll();
                cnt++;
            }
            answer.add(cnt);
        }
        
        int[] answer2 = new int[answer.size()];
        
        int i = 0;
        while(!answer.isEmpty()){
            answer2[i] = answer.poll();
            i++;
        }
        
        
        
        
        return answer2;
    }
}