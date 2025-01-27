import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        Integer [] cnt = new Integer [31];
        Arrays.fill(cnt, 0); 
        
        for(String s : strArr){
            cnt[s.length()]++;
        }
        Arrays.sort(cnt,Comparator.reverseOrder());
        
        return cnt[0];
    }
}