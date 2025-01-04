import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(arr[0]);
        
        for (int i = 1; i < arr.length; i++){
            if (dq.getLast()==arr[i]){
                continue;
            }
            else {
                dq.addLast(arr[i]);
            }
        }
        
        // dq.stream().forEach(System.out::println);        
        
        int[] answer = dq.stream()
                         .mapToInt(Integer::intValue)
                         .toArray();

        return answer;
    }
}