import java.util.*;


class Solution {
    
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        HashSet<Integer> lostSet = new HashSet<>();
        HashSet<Integer> reserveSet = new HashSet<>();
        
        for (int l : lost){
            lostSet.add(l);
        }
        for (int r : reserve){
            if(lostSet.contains(r)){
                lostSet.remove(r);
                continue;
            }
            reserveSet.add(r);
        }
        
       
        int pCnt = 0;
        
        for (int l : lostSet){
            if (reserveSet.contains(l-1)){
                reserveSet.remove(l-1);
                pCnt++;
            }else if (reserveSet.contains(l+1)){
                reserveSet.remove(l+1);
                pCnt++;
            }
        }
        
        return answer-lostSet.size()+pCnt;
    }
    
        
        
    
    
}