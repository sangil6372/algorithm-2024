import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = -1;
        
        answer = (int)Arrays.stream(skill_trees)
                    .map(n -> n.replaceAll("[^"+ skill + "]",""))
                    .filter(n -> skill.startsWith(n))
                    .count();
        
        
        return answer;
    }
}