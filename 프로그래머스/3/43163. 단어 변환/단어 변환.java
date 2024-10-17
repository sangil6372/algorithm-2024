import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> dist = new HashMap<>(); // 각 단어의 변환 단계를 저장하는 맵
        Set<String> set = new HashSet<>();
        
        queue.add(begin);
        dist.put(begin,0);
        set.add(begin);
        
        while(!queue.isEmpty()){
            String s = queue.poll();
            if (s.equals(target)){
                return dist.get(s);
            }
            
            for (String w : words){
                if (!set.contains(w) && canTransform(s, w)){
                    dist.put(w,dist.get(s)+1);
                    set.add(w);
                    queue.add(w);
                    
                }
                
                
            }
            
        }
        
        return 0;
        
        
    }
    
    public boolean canTransform(String word1, String word2){
        int cnt = 0;
        for (int i = 0; i < word1.length();i++){
            if (word1.charAt(i)!=word2.charAt(i)){
                cnt++;
            }
            if (cnt>1){
                    return false;
            }
        }
        return cnt == 1;
    }
}