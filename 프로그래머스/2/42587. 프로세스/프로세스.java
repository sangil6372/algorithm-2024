import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Deque<int[]> deque = new ArrayDeque<>();
        
        for (int i = 0; i<priorities.length;i++){
            if (i == location){
                deque.addLast(new int[] {priorities[i],1}); // 이거 리터럴 넣는 방식 왜 안됨??    
            }
            deque.addLast(new int[] {priorities[i],0});
        }
        
        int cnt = 1;
        while(!deque.isEmpty()){
            int[] tmp = deque.pollFirst();
            
//            if (tmp[1]==1) return cnt;
            
            boolean hasProperty = false;
            for (int[] n : deque){      // queue도 이런식으로 순회가 가능 
                if (tmp[0]<n[0]){
                    hasProperty = true;
                }
            }
            
            if (hasProperty) deque.addLast(tmp);
            else { // 실행 
                if (tmp[1]==1) return cnt;
                cnt++;
            }
            
        }
        
        
        return answer;
    }
}