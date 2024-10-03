import java.util.*;


class Solution {
    public int[] solution(int[] array, int[][] commands) {
         
        int[] result = new int[commands.length];
        
        for (int i = 0 ; i< commands.length ; i++){
            int start = commands[i][0]-1;
            int end = commands[i][1]-1;
            int key = commands[i][2]-1;
            
            int[] subArr = new int[end-start+1];
            for (int j = 0; j < end-start+1; j++){
                subArr[j] = array[start+j];
            }
//            int[] answer = Arrays.copyOfRange(array,start,end); 
            Arrays.sort(subArr);
            
            result[i] = subArr[key];
        }   
    
        return result;
    }
}