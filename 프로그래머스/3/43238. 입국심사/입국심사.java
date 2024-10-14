import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long start = 1;
        
        long maxTime = 0;
        for (int t : times){
            if (t > maxTime) maxTime = t;
        }
        long end = maxTime*(n);
        
        
        while (start <= end) {
            long mid = (start+end)/2;
            
            long sum  = 0; 
            //tartget 찾은 경우 
            for (int t : times) {
                sum += mid/t;
            }            
            
            
            // 중간 값보다 작은 경우 = n보다 더 많은 사람을 수용가능한 경우  
            if ( n <= sum ){
                answer = mid;
                end = mid-1;
            }
            
            else 
                start = mid+1;
            
        }
        return answer;
    }
}