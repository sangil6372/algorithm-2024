import java.util.*;


class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
    
        for (String operation : operations){
            String[] op = operation.split(" ");
            
            if (op[0].equals("I")){
                maxQ.add(Integer.parseInt(op[1]));
                minQ.add(Integer.parseInt(op[1]));
                
            }else if (op[0].equals("D")){
                if (maxQ.isEmpty()) continue;
                if (op[1].equals("1")){
                    int x = maxQ.poll();
                    minQ.remove(x);
                }else if (op[1].equals("-1")){
                    int x = minQ.poll();
                    maxQ.remove(x);
                }
            }
        }
        if (maxQ.size()>=1){
            answer[0] = maxQ.peek();
            answer[1] = minQ.peek();
        }
        
        
        return answer;
    }
}