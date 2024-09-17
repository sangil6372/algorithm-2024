import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < arr.length ; i++){ // 반복문 효율적인 사용법으로 변경 필요 
            if (stack.isEmpty()||stack.peek()!=arr[i]){
                stack.push(arr[i]);  // 왜 stack 은 add가 아니라 push지? 
            }
        }
        
        // stack 사이즈 만큼 배열 선언
        int[] answer = new int[stack.size()];
        for (int i = stack.size()-1; i >= 0; i--) {
            answer[i] = stack.pop();
        }


        return answer;
    }
}