import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        
        for (int l : lost){
            lostSet.add(l);
        }
        for (int re : reserve){
            if (lostSet.contains(re)){
                lostSet.remove(re); // 카운팅 하기보다 그냥 잃어버린 세트에서 제거만 하면 됨
            }else{
                reserveSet.add(re);
            }
        }
       
        int cnt = 0; 
        for (int l : lostSet){
            if (reserveSet.contains(l-1)){
                reserveSet.remove(l-1);
                cnt++;
                }else if (reserveSet.contains(l+1)){
                reserveSet.remove(l+1);
                cnt++;
            }        
        }
    
        return n-lostSet.size()+cnt;
    }
}