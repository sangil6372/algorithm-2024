import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] cmd : commands){
            int start = cmd[0];
            int end = cmd[1];
            int key = cmd[2];
            
            int[] subArr = new int[end-start+1];
            for (int i = 0; i<subArr.length;i++){
                subArr[i] = array[i+start-1];
            }
            Arrays.sort(subArr);
            answer[idx] = subArr[key-1];
            idx++;
        }
        
        
        return answer;
    }
}