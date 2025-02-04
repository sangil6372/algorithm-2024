import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        
        if (n>s) return new int[] {-1};
        
        
        /*
        자연수 n개 의 합 = s 
        각 n개의 곱 최대 
        균등 분배 ?
        */
        
        int base = s/n;
        int remainder = s%n;
        
        Arrays.fill(answer, base);  // {4,4,4,4}
        
        for (int i = 0; i< remainder ;i++){
            answer[n-i-1]++;
        }
        
        
        
        return answer;
    }
}