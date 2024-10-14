 import java.util.*;


class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int start = 1;
        int end = distance;
        
        while (start  <= end ){
            
            int mid = (start + end)/2;     // mid 는 최솟값을 담아낼 것임
            
            
            // 바위 순회 하면서 바위를 지울 것임 ,가상으로
            // 1. 지울 수 있다면 removeCnt ++;
            // 2. 못 지운다면 minDistance 랑 prev 갱신 
            
            int prev = 0;
            int removeCnt  =0;
            int minDistance = Integer.MAX_VALUE;
            
            
            for (int r : rocks){
                if ((r-prev)<mid) removeCnt++;
                else {
                    minDistance = Math.min(minDistance, (r-prev));
                    prev = r;
                }
            }
            
            if (distance - prev<mid) removeCnt++;
            else minDistance = Math.min(minDistance, distance-prev);
            
            if (removeCnt <= n){ // 덜 지우고 mid 조건을 만족함 
                answer = mid;
                start = mid+1;
            }        
            else{
                end = mid-1;
            }
            
            
            
        }
        
        
        
        
        
        return answer;
    }
}