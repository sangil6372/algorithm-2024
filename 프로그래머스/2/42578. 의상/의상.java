import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        Map<String, Integer> fashion = new HashMap<>();
        
        for (String[] c : clothes){
            fashion.put(c[1],fashion.getOrDefault(c[1],0)+1);
        }
        
        // 카테고리 조합 계산 
        answer = 1;
        for (int cnt : fashion.values()){
                answer *= (cnt+1);
        }
        answer --;
        
        return answer;
    }
}